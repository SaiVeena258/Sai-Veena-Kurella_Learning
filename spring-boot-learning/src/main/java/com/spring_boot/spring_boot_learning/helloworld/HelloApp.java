package com.spring_boot.spring_boot_learning.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloApp {
    
    public static void main(String[] args) {
        
        try(var context=
            new AnnotationConfigApplicationContext
                (HelloConfiguration.class)){

            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean("mainaddress",Address.class));
            System.out.println(context.getBean("address1"));

        }     
    }

}