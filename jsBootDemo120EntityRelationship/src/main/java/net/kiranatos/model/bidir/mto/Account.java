package net.kiranatos.model.bidir.mto;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_acc")
public class Account {

    @Id
    @Column(name = "id_acc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_acc")
    private String name;

    @Column(name = "amount_acc")
    private long amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", amount=" + amount + '}';
    }
}
