package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applications {
    public static void main(String[] args) {
        System.out.println(" <<< Spring Boot Demo05 Application: JavaRush - Spring not scare Example >>> ");
        SpringApplication.run(Applications.class /*, args*/);
    }
}

/*
SELECT * FROM FRUIT_TABLE; 
SELECT * FROM PROVIDER_TABLE;

Task 1: Проект автора "Spring — это не страшно", можливо знаходиться тут:
    https://bitbucket.org/FromJava/jd/src/master/ / git clone https://FromJava@bitbucket.org/FromJava/jd.git
    https://javarush.com/groups/posts/3099-spring-ehto-ne-strashno--ili-kak-zadatjh-vopros-bd
    Я ще не скачував і не дивився.

Task 2: В FruitRepository є методи на JPQL та SQL. Тому, повторити SQL і розібратись JPQL. Джавраш статья не дає повного розуміння. 
    Але оскільки все спрацювало, поки-що йдемо далі.
    Натрапив на статью: https://www.baeldung.com/spring-data-jpa-query - це може бути саме те, що мені потрібно.

Task 3: B hsSoftInstallInstructions добавить пункти встановки Мавен i Gradle.
        B jsJDBC добавить пункти встановки PostgresSQL and others.

Task 50: проекти jsBootDemo200QueryMethods, jsBootDemo201QueryMethodsBiDir і jsBootDemo300JavaRushSpringNotScare можуть мати спільні Task, що перетинаються.

Task 5: Думаю над тим, щоб переробить ці дві БД таблиці, щоб вони були зв'язаними між собою.

Task 4: В статті https://javarush.com/groups/posts/3099-spring-ehto-ne-strashno--ili-kak-zadatjh-vopros-bd
    рекомендували реализовать два тренировочных проекта:
        Проект про покраску машин:
Первый класс:
CarEntity{
Integer id;
String modelName;
String color;
}

Второй класс:
ColorEntity{
Integer id;
String color;
Integer price;
}

Наполните базу (придумайте реалистичные названия так будет легче для понимания), 
реализуйте: , entity, repositories, services, создайте стандартные и межтабличные з
апросы (Сколько стоит покраска  BMW  в красный цвет? Какой цвет самый дорогой? Напишите модели в консоль в алфавитном порядке и т.д.);

        Проект про библиотеку:
Первый класс:
BookEntity{
Integer id;
String nameBook;
Integer yearCreat;
Integer autorId;
}

Второй класс:
AutorEntity{
Integer id;
String firstNameAutor;
String lastNameAutor;
}
Наполните базу (придумайте реалистичные названия так будет легче для понимания), 
реализуйте: entity, repositories, services, создайте стандартные и межтабличные 
запросы (Кто написал какую книгу? Какая книга написана раньше всех? Какие книги 
были написаны с 1800 по 1900? Кто из авторов написал больше всего книг?);
Примеры для заполнения базы проекта "Библиотека"
Таблица книг
BookEntity(id=1, nameBook=Горе от ума, yearCreat=1824, authorId=1)
BookEntity(id=2, nameBook=Война и мир, yearCreat=1863, authorId=2)
BookEntity(id=3, nameBook=Мцыри, yearCreat=1838, authorId=3)
BookEntity(id=4, nameBook=Евгений Онегин, yearCreat=1833, authorId=4)

Таблица авторов
AuthorEntity(id=1, firstNameAuthor=Александр, lastNameAuthor=Грибоедов)
AuthorEntity(id=2, firstNameAuthor=Лев, lastNameAuthor=Толстой)
AuthorEntity(id=3, firstNameAuthor=Михаил, lastNameAuthor=Лермонтов)
AuthorEntity(id=4, firstNameAuthor=Александр, lastNameAuthor=Пушкин)


*/