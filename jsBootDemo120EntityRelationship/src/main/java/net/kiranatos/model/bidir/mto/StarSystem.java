package net.kiranatos.model.bidir.mto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "myStarSystem")
public class StarSystem {

    @Id
    @Column(name = "sysId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sysName")
    private String name;

    /* The mappedBy attribute specifies the name of the attribute in the Planet entity that owns the relationship.
    In this case, the StarSystem entity doesn’t own the relationship, so we specify mappedBy = “starSystemF”.*/
    @OneToMany(mappedBy = "starSystemF")
    private List<Planet> planets;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "StarSystem{" + "id=" + id + ", name=" + name + ", planets=" + planets + '}';
    }
}
