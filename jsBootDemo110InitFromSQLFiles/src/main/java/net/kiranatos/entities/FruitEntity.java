package net.kiranatos.entities;

import jakarta.persistence.*; // old variant: javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity // позначаємо бін як сутність, яка є POJO-класом(сеттери, геттери, конструктор, toString)
@Table(name = "fruit_table") // в цій анотації можна вказати ім'я таблиці, що створюється
public class FruitEntity {

    @Id 
    @Column(name = "id_fruit") // ім'я поля
    @GenericGenerator(name = "generator", strategy = "increment") // пояснення див. в проекті jsBootDemo15GeneratedID
    @GeneratedValue(generator = "generator") 
    private Integer idFruit;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "provider_code")
    private Integer providerCode;

    public FruitEntity() {    }

    public Integer  getId()             { return idFruit; }    
    public String   getFruitName()      { return fruitName; }
    public Integer  getProviderCode()   { return providerCode; }

    public FruitEntity setFruitName(String fruitName) {
        this.fruitName = fruitName;
        return this;
    }    

    public FruitEntity setProviderCode(Integer providerCode) {
        this.providerCode = providerCode;
        return this;
    }

    @Override
    public String toString() {
        return "FruitEntity{"
                + "id=" + idFruit
                + ", fruitName='" + fruitName + '\''
                + ", providerCode=" + providerCode
                + '}';
    }
}