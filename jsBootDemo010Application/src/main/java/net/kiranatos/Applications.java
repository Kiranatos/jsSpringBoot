package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Аплікація на Java, яка піддіймає веб-сервер!
TomcatWebServer стартує на порту 8080.
Так як сервер не відправляє ніяку інформацію, то в браузері за посиланням http://localhost:8080/
буде відображатись стандартна Whitelabel Error Page */

@SpringBootApplication
public class Applications {

    public static void main(String[] args) {
        SpringApplication.run(Applications.class);
    }
}