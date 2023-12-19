package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "planet_table")
public class PlanetEntity {

    @Id
    @Column(name = "id_planet")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "planet_name")
    private String planetName;

    @Column(name = "insolarsystem")
    private Boolean inSolarSystem;

    public PlanetEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public Boolean getInSolarSystem() {
        return inSolarSystem;
    }

    public void setInSolarSystem(Boolean inSolarSystem) {
        this.inSolarSystem = inSolarSystem;
    }

    @Override
    public String toString() {
        return "PlanetEntity{" + "id=" + id + ", planetName=" + planetName + ", inSolarSystem=" + inSolarSystem + '}';
    }
}


