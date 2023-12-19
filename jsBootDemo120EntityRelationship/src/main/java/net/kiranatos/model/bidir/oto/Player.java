package net.kiranatos.model.bidir.oto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "myPlayer")
public class Player {

    @Id
    @Column(name = "plaId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plaName")
    private String name;

    @OneToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name=" + name + ", role=" + role + '}';
    }

}
