package com.springboot.spring_boot_learning_01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class MainClass{

    @Autowired
    public MainClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }
    
    Dependency1 dependency1;
    Dependency2 dependency2;

    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - Dependency 1");
        this.dependency1 = dependency1;
    }

    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - Dependency 2");
        this.dependency2 = dependency2;
    }

    public String toString(){
        return " Using " + dependency1 + " and " + dependency2;
    }  

}

@Component
class Dependency1{

}

@Component
class Dependency2{

}

@Configuration
@ComponentScan
public class DependencyInjection {
    public static void main(String[] args) {

        try(var context=
            new AnnotationConfigApplicationContext
                (DependencyInjection.class)){

                    Arrays.stream(context.getBeanDefinitionNames())
                        .forEach(System.out::println);;

                    System.out.println(context.getBean(MainClass.class));
                }
    }
}