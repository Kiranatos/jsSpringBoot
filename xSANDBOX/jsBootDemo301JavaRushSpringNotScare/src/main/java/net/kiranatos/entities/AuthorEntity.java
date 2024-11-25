package net.kiranatos.entities;


import jakarta.persistence.*; // old variant: javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Table(name = "AUTHORENTITY")
@Data
public class AuthorEntity {

    @Id
    @Column(name = "id_author")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "first_name")
    String firstNameAuthor;

    @Column(name = "last_name")
    String lastNameAuthor;

}
