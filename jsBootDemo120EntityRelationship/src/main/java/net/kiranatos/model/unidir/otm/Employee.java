package net.kiranatos.model.unidir.otm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "myEmployee")
public class Employee {
 
    @Id
    @Column(name = "empId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "empName")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + '}';
    }
    
}

