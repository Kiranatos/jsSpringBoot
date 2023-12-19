package net.kiranatos.model.unidir.otm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "myDepartment")
public class Department {

    @Id
    @Column(name = "depId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "depName")
    private String name;

    @OneToMany
    @JoinColumn(name = "department_id") 
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", employees=" + employees + '}';
    }
    
}
