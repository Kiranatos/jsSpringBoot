package net.kiranatos.entities;

import jakarta.persistence.*; // old variant: javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Table(name = "BOOKENTITY")
@Data
public class BookEntity {

    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name_book")
    String nameBook;

    @Column(name = "year_creat")
    Integer yearCreat;

    @Column(name = "author_id")
    Integer authorId;

}
