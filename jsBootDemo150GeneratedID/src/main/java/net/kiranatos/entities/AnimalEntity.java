package net.kiranatos.entities;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/* Вбудованні стратегії генерації ID Хібернейта: increment, identity, sequence, hilo, seqhilo, uuid, guid, native, assigned, select, foreign, sequence-identity */

@Entity
@Table(name = "animal_table")
public class AnimalEntity {

    @Id
    @Column(name = "id_animal")
    @GeneratedValue(generator="mySomeGenerator1")
    @GenericGenerator(name="mySomeGenerator1", strategy="increment") // increment стратегія    
    private Long id;
    /*
    uuid стратегія (GUID в Java называется UUID, так исторически пошло)      
    @GenericGenerator(name="mySomeGenerator", strategy="uuid") // increment 
    private String id;
    
    assigned стратегія - id мають ініціалізуватись вручну. Тут як варіант: {1} - розкомментувати в конструкторі
    @GenericGenerator(name="mySomeGenerator", strategy="assigned")
    
    enhanced-sequence стратегія - This strategy is designed to be more efficient than the standard sequence strategy, especially in applications that have a high write volume.
    @GenericGenerator(name="mySomeGenerator1", strategy="enhanced-sequence",
            parameters = {
                @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled"),
                @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"), // початковий id
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "2") // шаг чомусь не спрацьовує, можливо це прикол H2 бд
            }
    )
    
    Всі інші стратегії ще не перевіряв.
    
    Інші вбудованні стратегії генерації ID Хібернейта, можна глянути тут:
    5.1.4.1. Generator
    https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/mapping.html#mapping-declaration-id    
    */
    
    @Column(name = "animal_name")
    private String animalName;

    @Column(name = "predator")
    private Boolean isPredator;

    public AnimalEntity() {
        /* id = (long)(Math.random()* System.currentTimeMillis()); {1} */
    }

    public Long getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Boolean getIsPredator() {
        return isPredator;
    }

    public void setIsPredator(Boolean isPredator) {
        this.isPredator = isPredator;
    }

    @Override
    public String toString() {
        return "AnimalEntity{" + "id=" + id + ", animalName=" + animalName + ", isPredator=" + isPredator + '}';
    } 
}


