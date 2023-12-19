package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applications {
    public static void main(String[] args) {        
        SpringApplication.run(Applications.class);
    }
}

/*
SELECT * FROM BANK_ACC  ; 
SELECT * FROM BANK_USER ;

SELECT * FROM MY_BOOK ;
SELECT * FROM MY_AUTHOR ;
SELECT * FROM BOOK_AUTHOR ;

SELECT * FROM MY_SCHOOL ;
SELECT * FROM MY_STUDENT ;

SELECT * FROM MY_DEPARTMENT ;
SELECT * FROM MY_EMPLOYEE  ; 

SELECT * FROM MY_PARKING_SPOT;
SELECT * FROM MY_CAR;

SELECT * FROM MY_PLANET;
SELECT * FROM MY_STAR_SYSTEM  ;

SELECT * FROM MY_PUPIL ;
SELECT * FROM MY_LESSON   ;
SELECT * FROM LESSON_PUPIL ;

SELECT * FROM MY_ROLE ;
SELECT * FROM MY_PLAYER  ;

Understanding JPA/Hibernate Associations
    https://www.baeldung.com/jpa-hibernate-associations
    https://github.com/eugenp/tutorials/tree/master/persistence-modules/hibernate-mapping-2
    Все законспектовано.

Entity Relationship in JPA/Hibernate/ORM
    https://javatechonline.com/entity-relationship-in-jpa-hibernate-orm/
    Законспектовано до заголовку FAQ внизу.

One-to-One Relationship in JPA
    https://www.baeldung.com/jpa-one-to-one
    Реалізувать цікаві варіанти @OneToOne відношень
    Нічого не законспектовано

Overview of JPA/Hibernate Cascade Types
    https://www.baeldung.com/jpa-cascade-types
    Cascade-ні типи
    Нічого не законспектовано
Hibernate’s “Object References an Unsaved Transient Instance” Error
    https://www.baeldung.com/hibernate-unsaved-transient-instance-error
    Помилка TransientObjectException
    Нічого не законспектовано

https://habr.com/ru/articles/542328/
- Спробувать добитись, щоб було 2 доп. таблиці при ManyToMany
- Попробувать, щоб @ManyToOne і @OneToMany працювали на голо, без вказівок.
*/