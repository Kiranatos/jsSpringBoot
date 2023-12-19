package net.kiranatos.model.bidir.mtm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "myLesson")
public class Lesson {

    @Id
    @Column(name = "lesId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "lesName")
    private String name;

    @ManyToMany
    @JoinTable(name = "lesson_pupil",
            joinColumns = @JoinColumn(name = "les_id"),
            inverseJoinColumns = @JoinColumn(name = "pup_id"))
    private List<Pupil> pupilsG;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pupil> getPupilsG() {
        return pupilsG;
    }

    public void setPupilsG(List<Pupil> pupilsG) {
        this.pupilsG = pupilsG;
    }

    @Override
    public String toString() {
        return "Lesson{" + "id=" + id + ", name=" + name + ", pupilsG=" + pupilsG + '}';
    }
}
