package net.kiranatos.entities;

import jakarta.persistence.*;

/* TABLE - Для генерації id використовується окрема таблиця, яка містить два стовпчики: 
ім'я і лічильник. Перш ніж вставити новий рядок, Hibernate звертається до цієї таблиці, 
збільшує лічильник і використовує його значення як id для нового рядка. 
Ця стратегія дає вам дещо більше контролю над генерацією id, і ви можете визначити спеціальну таблицю для цього*/

@Entity
@Table(name = "fruit_table")
public class FruitEntity {

    @Id
    @Column(name = "id_fruit")    
    @GeneratedValue(strategy = GenerationType.TABLE)
    /* My minimum configuration. Вказав тільки @GeneratedValue(strategy = GenerationType.TABLE)
    Без @TableGenerator, і в schema.sql нічого не вказував.    
    В бд H2, хібернейт створив табл HIBERNATE_SEQUENCES:
    | SEQUENCE_NAME  |  NEXT_VAL |
    |----------------|-----------|
    | default        |  100      |
    Створення осн.табл. FRUIT_TABLE має id 1...8
    
    Див. продовження в PlanetEntity */
    private Long id;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "sugar")
    private Integer sugar;

    public FruitEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Integer getSugar() {
        return sugar;
    }

    public void setSugar(Integer sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "FruitEntity{" + "id=" + id + ", fruitName=" + fruitName + ", sugar=" + sugar + '}';
    }

}
