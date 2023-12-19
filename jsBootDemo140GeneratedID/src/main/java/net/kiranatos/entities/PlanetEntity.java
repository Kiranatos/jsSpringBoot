package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "planet_table")
public class PlanetEntity {

    @Id
    @Column(name = "id_planet")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "myNameOfTableGenerator")
    @TableGenerator(
            name = "myNameOfTableGenerator", // ім'я цього @TableGenerator
            table = "myNameOfTableInDB", // ім'я таблиці MY_NAME_OF_TABLE_INDB в БД
            pkColumnName = "myIDColumn", // ім'я ID колонки в таблиці в БД
            valueColumnName = "myValueColumn", // ім'я колонки зі значенням в таблиці в БД
            //pkColumnValue="someOtherName", // за замовчуванням в колонці myIDColumn ставить в якості значення - ім'я (planet_table) таблиці сутностей. Але цим параметром можна вказати інше значення (someOtherName)
            initialValue = 10, //id in table PLANET_TABLE starts with 11
            //catalog = "INFORMATION_SCHEMA", //will create table MY_NAME_OF_TABLE_INDB in folder INFORMATION_SCHEMA, folder should exist beforehand
            //schema = "my_schema", // didn't check it, but must be same as with catalog above.
            // uniqueConstraints - як працює ще не розібрався
            allocationSize=2)  // щось накшталт буфера або резервування майбутніх комірок  
    /* В БД H2, хібернейт створив табл MY_NAME_OF_TABLE_INDB на 3 сутності:
    | MYIDCOLUMN   | MYVALUECOLUMN |
    |--------------|---------------|
    | planet_table |   24          |
    | plant_table  |   22          |
    | plane_table  |   45          |    
    SELECT * FROM MY_NAME_OF_TABLE_INDB; 
    SELECT * FROM PLANET_TABLE; 
    SELECT * FROM PLANT_TABLE;
    SELECT * FROM PLANE_TABLE;
    Мої дослідження: в PlantEntity не вказую @TableGenerator, але вказую тільки на генератор myNameOfTableGenerator, 
    який знаходиться в цьому класі PlanetEntity і воно його підхоплює... мабуть, хоча робивши це саме перед цим в класі 
    PlaneEntity це не спрацювало і створило окрему таблицю.
    В PlaneEntity вказані ті ж самі значення для параметрів: table, pkColumnName, valueColumnName щоб використовувало одну 
    й ту ж таблицю, а не створювало окрему і не падало з помилкою. 
    З initialValue і allocationSize можна гратись.
    Значення в MYVALUECOLUMN є щось накшталт лічильника, на який впливають initialValue і allocationSize.    */
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


