package com.zmeevsky.springtask.config;

import com.zmeevsky.springtask.model.Cat;
import com.zmeevsky.springtask.model.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
 
    @Bean(name="helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

    @Bean(name = "cat")
    @Scope(value = "prototype")
    public Cat getCat() {
        Cat cat = new Cat();
        cat.setName("Barsik");
        cat.setAge(3);
        return cat;
    }
}