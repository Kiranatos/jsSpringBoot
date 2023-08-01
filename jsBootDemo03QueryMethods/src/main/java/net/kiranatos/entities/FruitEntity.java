package net.kiranatos.entities;

import jakarta.persistence.*; // old variant: javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.experimental.Accessors;

@Entity
@Table(name = "fruit_table")
@Accessors(fluent = true)
public class FruitEntity {

    @Id 
    @Column(name = "id_fruit") 
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator") 
    private Integer id;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "provider_code")
    private Integer providerCode;

    public FruitEntity() {    }

    public Integer  getId()             { return id; }    
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
                + "id=" + id
                + ", fruitName='" + fruitName + '\''
                + ", providerCode=" + providerCode
                + '}';
    }
}