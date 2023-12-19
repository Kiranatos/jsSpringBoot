package net.kiranatos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "drink_table")
public class DrinkEntity {

    @Id
    @Column(name = "id_drink")
    @GeneratedValue(generator="mySomeGenerator2")    
//    @GenericGenerator(
//            name = "mySomeGenerator2",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                @Parameter(name = "sequence_name", value = "user_sequence"),
//                @Parameter(name = "initial_value", value = "6"), // початковий id
//                @Parameter(name = "increment_size", value = "3")  // шаг чомусь не спрацьовує, можливо це прикол H2 бд
//            }    
//    )
    @GenericGenerator(
            name = "mySomeGenerator2",
            strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                @Parameter(name = "table_name", value = "MY_TABLE_GENERATOR"),
                @Parameter(name = "initial_value", value = "1"),    // початковий id
                @Parameter(name = "increment_size", value = "1"),   // шаг чомусь не спрацьовує
                @Parameter(name = "prefer_entity_table_as_segment_value", value = "true")
            }
    )            
    private Long id;
    
    /*
    org.hibernate.id.SequenceGenerator - deprecated, use org.hibernate.id.enhanced.SequenceStyleGenerator
    
    класси для strategy можна знайти в документації:
        https://docs.jboss.org/hibernate/orm/5.4/javadocs/index.html?overview-summary.html (
            org.hibernate.id
            org.hibernate.id.enhanced
            org.hibernate.id.factory
            org.hibernate.id.factory.spi
            org.hibernate.id.insert
            org.hibernate.id.uuid )
    parameters - це певні їх методи, як їх корректно знаходить, ще не розібравсь.
    
    Тут розповідається, як можна самому створити свій користувацький класс-генератор
        How to combine the Hibernate assigned generator with a sequence or an identity column
        https://vladmihalcea.com/how-to-combine-the-hibernate-assigned-generator-with-a-sequence-or-an-identity-column/
    */

    @Column(name = "drink_name")
    private String drinkName;

    @Column(name = "alcohol")
    private Boolean isAlcohol;

    public DrinkEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public Boolean getIsAlcohol() {
        return isAlcohol;
    }

    public void setIsAlcohol(Boolean isAlcohol) {
        this.isAlcohol = isAlcohol;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    @Override
    public String toString() {
        return "DrinkEntity{" + "id=" + id + ", drinkName=" + drinkName + ", isAlcohol=" + isAlcohol + '}';
    }
}
