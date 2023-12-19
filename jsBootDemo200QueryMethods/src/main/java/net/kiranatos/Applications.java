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
        System.out.println(" <<<RUN Applications class>>> ");
        SpringApplication.run(Applications.class, new String[]{" [args-данні, які передаються від класса Applications до InitiateUtils] "});
    }
}

/*
SELECT * FROM FRUIT_TABLE ;

                    Класи в яких реалізовані демонстрації і на які звернуть увагу:
Demonstration #1
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
Demonstration #2
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
Demonstration #3
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
Demonstration #4
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils]
Demonstration #5
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils]
Demonstration #6
    jsBootDemo200QueryMethods [FruitRepository, FruitService, InitiateUtils]
    jsBootDemo201QueryMethodsBiDir [AccountRepository, AccountService, UserRepository, UserService, InitiateUtils]
Demonstration #7
    jsBootDemo200QueryMethods []
    jsBootDemo201QueryMethodsBiDir []


*/