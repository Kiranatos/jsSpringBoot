package net.kiranatos.entities;

import jakarta.persistence.*; // old variant: javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Accessors(chain = true) // дозволяє автоматично згенерувати сеттери, які повертають this замість void і викликати їх у стилі білдера.
@Entity
@Data
@Table(name = "provider_table")
public class ProviderEntity {

    @Id
    @Column(name = "id_provider")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(name = "provider_name")
    private String providerName;

}