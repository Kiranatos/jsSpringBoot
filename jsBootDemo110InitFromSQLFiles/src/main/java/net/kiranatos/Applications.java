package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Аплікація на Java, яка піддіймає веб-сервер!
Запускається через Shift+F6, для F6 треба настроїти main class in project properties.
Преднастройок і установок робити не треба.
TomcatWebServer стартує на порту 8080.
Так як сервер не відправляє ніяку інформацію, то в браузері за посиланням http://localhost:8080/
буде відображатись стандартна Whitelabel Error Page */

@SpringBootApplication
public class Applications {

    public static void main(String[] args) {
        System.out.println(" <<<RUN Applications>>> ");
        SpringApplication.run(Applications.class, new String[]{" [args-данні, які передаються від класса Applications до InitiateUtils] "});
    }
}

/* TASKS:

1) 
Quick Guide on Loading Initial Data with Spring Boot
https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
 - законспектувати
 - погратися з можливими варіантами після аналізу цієї статьї і створити проекти: 0111, 0112,...


2) створити проект з заповненням (з класів та sql-файлів) складніших таблиць з FK




*/