package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "fruit_table")
public class FruitEntity {

    @Id
    @Column(name = "id_fruit")    
    @GeneratedValue(strategy = GenerationType.AUTO)
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
