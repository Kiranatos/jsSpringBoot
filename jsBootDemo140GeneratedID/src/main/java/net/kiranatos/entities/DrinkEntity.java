package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "drink_table")
public class DrinkEntity {

    @Id
    @Column(name = "id_drink")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*<gpt> Стратегія IDENTITY використовує автоінкрементні стовпці, що надаються БД
    для генерації унікальних значень. Тобто, БД сама зберігає і підтримує лічильник для поля.
    Недоліком є те, що ви не можете впливати на генерацію і не можете отримати значення id, 
    яке буде надане базою даних до вставки
    
     ================ IDENTITY vs. SEQUENCE ================
    IDENTITY:
     - Підтримується багатьма БД (H2, MySQL, PostgreSQL, SQL Server)
     - Зазвичай використовує автоматичне інкрементування внутр. лічильника БД для генерації унікальних значень первинного ключа.
     - Початкове значення та інкремент можуть бути налаштовані на рівні БД або таблиці.
     - Не завжди підтримує пакетну (batch) вставку записів з використанням JPA, 
    оскільки БД сама призначає значення первинного ключа під час вставки.
    SEQUENCE:
     - Підтримується деякими БД (H2, PostgreSQL, Oracle)
     - Використовує окремий об'єкт "послідовності" (sequence), який генерує унікальні значення.
     - Дозволяє більший контроль над генерацією первинних ключів, завдяки можливості 
    налаштування параметрів послідовності, таких як початкове значення, інкремент і т.д.
     - Зазвичай підтримує пакетну (batch) вставку записів, що може покращити продуктивність 
    під час вставки багатьох записів.    </gpt> */
    private Long id;

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
