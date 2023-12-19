package net.kiranatos.model.bidir.oto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "myRole")
public class Role {

    @Id
    @Column(name = "rolId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "rolName")
    private String name;

    @OneToOne(mappedBy = "role"/*, cascade = CascadeType.ALL*/) // Див. пояснення про помилку TransientObjectException в AnnotationsVocabulary.docx, Chapter 1.
    //@JoinColumn(name = "idZZzz") - useless, don't do anything, since FK column in Player table.
    private Player player;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name=" + name + ", player=" + player + '}';
    }

}
