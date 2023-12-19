package net.kiranatos.model.bidir.mto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "myPlanet")
public class Planet {

    @Id
    @Column(name = "plnId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plnName")
    private String name;    
    
    @ManyToOne
    @JoinColumn(name = "idSystem")
    private StarSystem starSystemF;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StarSystem getStarSystem() {
        return starSystemF;
    }

    public void setStarSystem(StarSystem starSystem) {
        this.starSystemF = starSystem;
    }

    @Override
    public String toString() {
        return "Planet{" + "id=" + id + ", name=" + name + ", starSystem=" + starSystemF + '}';
    }
}