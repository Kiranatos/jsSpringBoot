package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "uniform_table")
public class UniformEntity {

    @Id
    @Column(name = "id_uniform")
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

    @Column(name = "uniform_name")
    private String uniformName;

    @Column(name = "color")
    private String color;

    public UniformEntity() {
    }

    public Long getId() {
        return id;
    }

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
