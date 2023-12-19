package net.kiranatos.entities;

import jakarta.persistence.*;
import java.util.UUID;

/* <gpt> UUID - це 128-бітний унікальний ідентифікатор. Він генерується за допомогою 
алгоритму GUID (Globally Unique Identifier). UUID не залежить від будь-якої БД
або системи, тому його можна використовувати для ідентифікації об'єктів у різних системах.
Це корисно, коли ви маєте справу з розподіленими системами або базами даних, 
де необхідно гарантувати унікальність ідентифікаторів навіть між різними серверами чи БД
Для використання стратегії UUID, вам слід використовувати тип поля java.util.UUID 
у вашій сутності та встановити відповідний генератор і стратегію у вашому JPA анотації @GeneratedValue. 
Переваги:
    Унікальні і не повторювані значення ПК.
    Переносимість. Не залежить від будь-якої бази даних або системи.
    Можна використовувати для ідентифікації об'єктів у різних системах.
    Безпека.
Недоліки:
    Більший розмір ПК, на відміну від цілочисельних значеннь.
    Швидше зростання об'єму таблиці
    Може бути складнішим для розуміння і використання, ніж цілочисельні значення ПК. </gpt>*/

@Entity
@Table(name = "uniform_table")
public class UniformEntity {

    @Id
    @Column(name = "id_uniform")
    @GeneratedValue(strategy = GenerationType.UUID) // with .AUTO works too
    /*id має вигляд типу: ed83fc13-a3c8-45ce-b496-3194e95871b0 */
    private UUID id;

    @Column(name = "uniform_name")
    private String uniformName;

    @Column(name = "color")
    private String color;

    public UniformEntity() {
    }

    /*public Long getId() {
        return id;
    }*/

    public String getUniformName() {
        return uniformName;
    }

    public void setUniformName(String uniformName) {
        this.uniformName = uniformName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "UniformEntity{" + "id=" + id + ", uniformName=" + uniformName + ", color=" + color + '}';
    }

}

// UUID id1 = UUID.fromString("d290f1ee-99b6-4600-b354-43030e7f4a45");
