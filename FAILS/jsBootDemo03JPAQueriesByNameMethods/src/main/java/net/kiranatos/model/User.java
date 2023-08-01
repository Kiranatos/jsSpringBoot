package net.kiranatos.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Data 
@Accessors(chain = true)
@Entity
//@Table(name = "user") - чекнуть чи потрібно чи hibenate сам створить
public class User {
    
    @Id
//    @Column(name = "id_fruit") - чекнуть чи потрібно чи саме стиворить
//    @GenericGenerator(name = "generator", strategy = "increment") - чекнуть чи потрібно чи саме стиворить
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // @GeneratedValue(generator = "generator")
    private long id;
    
    //    @Column(name = "id_fruit") - чекнуть чи потрібно чи саме стиворить
    private String name;
    
    @OneToMany(mappedBy = "user")
    //    @Column(name = "id_fruit") - чекнуть чи потрібно чи саме стиворить
    private Set<Account> accounts;
    
    // getters/setters/constructors - ломбок має створити
}