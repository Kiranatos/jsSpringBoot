package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plant_table")
public class PlantEntity {

    @Id
    @Column(name = "id_plant")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "plant_name")
    private String plantName;

    @Column(name = "perennial")
    private Boolean isPerennial;

    public PlantEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Boolean getIsPerennial() {
        return isPerennial;
    }

    public void setIsPerennial(Boolean isPerennial) {
        this.isPerennial = isPerennial;
    }

    @Override
    public String toString() {
        return "PlantEntity{" + "id=" + id + ", plantName=" + plantName + ", isPerennial=" + isPerennial + '}';
    }   

}


