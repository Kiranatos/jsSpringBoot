package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applications {

    public static void main(String[] args) {
        System.out.println(" <<<RUN Applications>>> ");
        SpringApplication.run(Applications.class, new String[]{" [args-данні, які передаються від класса Applications до InitiateUtils] "});
    }
}
