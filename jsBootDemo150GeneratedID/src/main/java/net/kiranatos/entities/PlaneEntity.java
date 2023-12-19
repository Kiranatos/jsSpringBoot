package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plane_table")
public class PlaneEntity {

    @Id
    @Column(name = "id_plane")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plane_name")
    private String planeName;

    @Column(name = "nWings")
    private int numOfWings;

    public PlaneEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public int getNumOfWings() {
        return numOfWings;
    }

    public void setNumOfWings(int numOfWings) {
        this.numOfWings = numOfWings;
    }

    @Override
    public String toString() {
        return "PlaneEntity{" + "id=" + id + ", planeName=" + planeName + ", numOfWings=" + numOfWings + '}';
    }

}


