package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applications {

    public static void main(String[] args) {
        System.out.println(" <<< Spring Boot Demo03 Application: Spring Data JPA - queries generated by names of the methods >>> ");        
        SpringApplication.run(Applications.class);
    }
}