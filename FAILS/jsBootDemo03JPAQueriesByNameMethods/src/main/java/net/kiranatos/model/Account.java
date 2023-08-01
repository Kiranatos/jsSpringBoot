package net.kiranatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Data 
@Accessors(chain = true)
@Entity
public class Account {
    
    @Id
    //    @Column(name = "id_fruit") - чекнуть чи потрібно чи саме стиворить
//    @GenericGenerator(name = "generator", strategy = "increment") - чекнуть чи потрібно чи саме стиворить
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    //    @Column(name = "id_fruit") - чекнуть чи потрібно чи саме стиворить
    private String name;
    
    //    @Column(name = "id_fruit") - чекнуть чи потрібно чи саме стиворить
    private long amount;
   
//    @ManyToOne
//    //    @Column(name = "id_fruit") - чекнуть чи потрібно чи саме стиворить
//    private User user;
    
    
   // getters/setters/constructors - ломбок має створити
}
