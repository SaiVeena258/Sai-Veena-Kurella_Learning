package com.springboot.spring_boot_learning_01;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
interface DataService{
    int[] retrieveData();
}

@Component
@Primary
class MongoDbDataService implements DataService{

    @Override
    public int[] retrieveData(){
        return new int[] {1,2,3};
    }
}

@Component
class MySQLDataService implements DataService{

    @Override
    public int[] retrieveData(){
        return new int[] {11,22,33};
    }
}

@Component
class BusinessCalculationService {
    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findmax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

@Configuration
@ComponentScan
public class BusinessApplication {
    public static void main(String[] args) {
        try(var context=
            new AnnotationConfigApplicationContext
                (BusinessApplication.class)){

                    Arrays.stream(context.getBeanDefinitionNames())
                        .forEach(System.out::println);
                    
                    System.out.println(context.getBean(BusinessCalculationService.class).findmax());
        }
    }
}