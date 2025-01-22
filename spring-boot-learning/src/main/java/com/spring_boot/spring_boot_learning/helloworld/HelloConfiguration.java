package com.spring_boot.spring_boot_learning.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name,int age,Address address){};
record Address(String city,String state){};

@Configuration
public class HelloConfiguration {

    @Bean
    public Person person(@Qualifier("mainaddress") Address address){
        return new Person("John",30,address);
    }

    @Bean(name = "mainaddress")
    @Qualifier("mainaddress")
    public Address address(){
        return new Address("Hyderabad", "Telangana");
    }

    @Bean
    public Address address1(){
        return new Address("RangaReddy", "Telangana");
    }

}
