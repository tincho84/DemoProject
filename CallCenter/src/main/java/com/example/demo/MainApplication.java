package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class MainApplication {


	public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);
    }


}
