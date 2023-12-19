package net.kiranatos.model.bidir.mtm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "myPupil")
public class Pupil {

    @Id
    @Column(name = "pupId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pupName")
    private String name;

    @ManyToMany(mappedBy = "pupilsG")
    private List<Lesson> lessons;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Pupil{" + "id=" + id + ", name=" + name + ", lessons=" + lessons + '}';
    }
}
