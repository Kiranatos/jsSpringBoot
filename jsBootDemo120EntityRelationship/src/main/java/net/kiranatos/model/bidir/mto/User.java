package net.kiranatos.model.bidir.mto;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank_user")
public class User {

    @Id
    @Column(name = "id_usr")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "name_usr")
    private String name;    
  
    
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "\tUser{" + "id=" + id + ", name=" + name + ", accounts=\n\t\t" + accounts + '}';
    }
}