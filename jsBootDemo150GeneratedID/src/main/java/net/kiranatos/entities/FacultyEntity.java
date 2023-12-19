package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty_table")
public class FacultyEntity {

    @Id
    @Column(name = "id_faculty")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(name = "university")
    private String university;

    public FacultyEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "FacultyEntity{" + "id=" + id + ", facultyName=" + facultyName + ", university=" + university + '}';
    }
}
