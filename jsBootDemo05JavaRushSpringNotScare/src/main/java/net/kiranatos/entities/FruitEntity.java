package net.kiranatos.entities;

import jakarta.persistence.*; // old variant: javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Data 
@Accessors(chain = true) /* дозволяє автоматично згенерувати сеттери, які повертають this замість void і викликати їх у стилі білдера.
Див. InitiateUtils в цьому проекті, AnnotationsVocabulary.docx та DemoAccessors в проекті jsLombokWithoutSpring. */
@Entity 
@Table(name = "fruit_table")
public class FruitEntity {

    @Id 
    @Column(name = "id_fruit")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "provider_code")
    private Integer providerCode;
}