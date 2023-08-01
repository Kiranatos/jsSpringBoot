package net.kiranatos.entity;

// for version 3.0.2
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* for version 2.3.3.RELEASE
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;*/

@Entity // <-- данный класс будет иметь отображение в базе данных.
@Table(name="employees") /* <-- говорит о том, к какой именно таблице мы привязываем класс.
employees - назва таблиці в БД. Якщо назвать класс Employees, то name в анотації можна не вказувати.
Проте для читабельності краще все ж таки вказувати незалежно від того, співпадає назва класу з таблицею чи ні. */
public class Employee {
    
    @Id // дана колонка Primary Key
    @Column(name="id") // відповідає колонці id в таблиці employees
    private int id;
    
    @Column // відповідає колонці name в таблиці employees
    private String name;
    
    @Column(name="surname") // відповідає колонці surname в таблиці employees
    private String secondName;
    
}

/*
Hibernate – это framework, который используется для сохранения, получения, изменения и удаления Java объектов из Базы Данных. Java application<-->Hibernate<-->Database
Плюсы Hibernate:
 - Предоставляет технологию ORM
 - Регулирует SQL запросы
 - Уменьшает количество кода для написания

ORM (Object-to-Relational Mapping) – это преобразование объекта в строку в таблице и обратное преобразование. class A <--> Hibernate <--> table A

Entity класс – это Java класс, который отображает информацию определённой таблицы в БД.
Entity класс – это POJO класс, в котором мы используем определённые Hibernate аннотации для связи класса с таблицей из БД.
POJO (Plain Old Java Object) – класс, удовлетворяющий ряду условий: private поля, getter-ы и setter-ы, конструктор без аргументов и т.д.

Аннотация @Column говорит о том, к какому именно
столбцу из таблицы мы привязываем поле класса
Аннотация @Id говорит о том, что в таблице, столбец
связанный с данным полем является Primary Key

JPA (Java Persistence API) – это стандартная спецификация, которая описывает систему для управления сохранением Java объектов в таблицы БД.
Hibernate – самая популярная реализация спецификации JPA. 
Тобто JPA описує/задає правила, а Hibernate їх реализує. І якщо потрібно буде змінити фраємворк Hibernate на інший JPA-подібний, то це буде легше зробити.
Тому і рекомендують використовувати import jakarta.persistence.*; або import javax.persistence.*; а не хібернейтовскі import org.hibernate.annotations.*;

*/