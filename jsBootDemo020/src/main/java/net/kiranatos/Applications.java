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
