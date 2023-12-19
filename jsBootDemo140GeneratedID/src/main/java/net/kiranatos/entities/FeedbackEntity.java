package net.kiranatos.entities;

import jakarta.persistence.*;
//import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "feedback_table")
public class FeedbackEntity {

    @Id
    @Column(name = "id_feedback")    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generator")
    @SequenceGenerator(name = "my_sequence_generator", sequenceName = "my_sequence", allocationSize = 1)
    /* Об'єкт "послідовності" зазвичай налаштовується один раз на рівні БД (в schema.sql) і зберігається в самій БД.
    Після чого вона використовується для генерації унікальних значень ПК в коді Java через JPA або SQL-запити.    
    Див. файл schema.sql:
        CREATE SEQUENCE my_sequence
        START WITH 990
        INCREMENT BY 2
        MINVALUE 10
        MAXVALUE 1000
        CYCLE;
    Створення послідовності my_sequence, яка починається зі значення 990, з кроком 2 та діапазоном [10;1000],
    циклічна(при перевищені 1000 почне заново з 10. Існуючі значення можуть бути затерті).
    Сгенеровані id мають вигляд: 10 12 14 16 18 20 990 992 994 996 998 1000
    
    ****************************************************************************
    
    <gpt> Параметр allocationSize (by default 50, використовується тільки в @SequenceGenerator і @TableGenerator) 
    вказує кількість значень, які відразу беруться з БД і 
    резервуються для використання. Зазвичай БД віддають блоки зі значеннями послідовності,
    щоб зменшити кількість запитів до БД при генерації нових значень.
    
    Що я зрозумів: трохи запутано і чимало ще не зрозуміло.
        allocationSize він як буфер запросів до бд.
        allocationSize = 1 в @SequenceGenerator і INCREMENT BY 2 якось зв'язані, 
    через що бувають exception-и. Гпт сказав, що логіка моя правильна, але інші 
    значення id і падіння exception-ів може бути пов'язано зі специфікою H2 бд.

    ****************************************************************************
    
    Це б мало бути аналогом анотацій @GeneratedValue та @SequenceGenerator, але в мене впало з помилкою:
    @GeneratedValue(generator = "my_sequence_generator")
    @GenericGenerator(name = "my_sequence_generator", strategy = "sequence", parameters = {
        @org.hibernate.annotations.Parameter(name = "sequence_name", value = "my_sequence"),
        @org.hibernate.annotations.Parameter(name = "allocation_size", value = "1")
    })  </gpt>    
    Task: повернутись пізніше і перепровірити.  */
    private Long id;

    @Column(name = "feedback_text")
    private String feedbackText;

    @Column(name = "nickname")
    private String nickname;

    public FeedbackEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "FeedbackEntity{" + "id=" + id + ", feedbackText=" + feedbackText + ", nickname=" + nickname + '}';
    }   
}
