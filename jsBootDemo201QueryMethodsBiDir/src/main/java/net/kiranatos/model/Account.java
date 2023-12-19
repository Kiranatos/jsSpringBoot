package net.kiranatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "bank_acc")
public class Account {

    @Id
    @Column(name = "id_acc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name_acc")
    private String name;

    @Column(name = "amount_acc")
    private long amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
