package com.spring.spring_boot_learning_02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class Animal{

}

@Component
@Lazy
class Dog{

	private Animal animal;

	public Dog(Animal animal){
		System.out.println("Bean Initialized");
		this.animal = animal;
	}

	public void bark(){
		System.out.println("Dog barks");
	}
}

@Configuration
@ComponentScan
public class LazyInitializer {

	public static void main(String[] args) {
		try(var context=
		new AnnotationConfigApplicationContext
		(LazyInitializer.class)){

			System.out.println("Initialize the bean");
			context.getBean(Dog.class).bark();
		}
	}

}
