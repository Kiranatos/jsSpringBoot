package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "animal_table")
public class AnimalEntity {

    @Id
    @Column(name = "id_animal")
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*<gpt> Стратегія AUTO дозволяє Hibernate самостійно вибрати найбільш підходящий механізм
    генерації id залежно від конкретної БД і драйвера. 
    У стратегії AUTO, Hibernate перевіряє по черзі наступні послідовністі стратегій для генерації первинного ключа:
        IDENTITY: Якщо БД підтримує автоінкрементні стовпці (напр.,  AUTO_INCREMENT в MySQL, SERIAL в PostgreSQL)
        SEQUENCE: Якщо БД підтримує послідовності (напр., Oracle)
        TABLE: Якщо ні IDENTITY, ні SEQUENCE не підходять, Hibernate створить таблицю для збереження 
    інформації про генерацію первинного ключа і використовуватиме TABLE.
        UUID: Якщо жодна з попередніх стратегій не підходить, або вказано іншу конфігурацію, 
    Hibernate використає UUID (унікальний ідентифікатор унікального об'єкта). </gpt> */    
    private Long id;

    @Column(name = "animal_name")
    private String animalName;

    @Column(name = "predator")
    private Boolean isPredator;

    public AnimalEntity() {
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


