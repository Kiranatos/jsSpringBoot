package net.kiranatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "bank_user")
@Data
public class User {

    @Id
    @Column(name = "id_usr")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name_usr")
    private String name;    
  
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Account> accounts; // {2}
    //private List<Account> accounts;
   
}