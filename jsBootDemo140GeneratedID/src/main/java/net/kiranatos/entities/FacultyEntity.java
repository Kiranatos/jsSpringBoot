package net.kiranatos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty_table")
public class FacultyEntity {

    @Id
    @Column(name = "id_faculty")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    /*<gpt> Стратегія SEQUENCE використовує послідовності БД (якщо підтримуються) 
    для генерації унікальних значень. Ви повинні вказати ім'я послідовності.
    Ви створюєте спеціальний об'єкт послідовності в БД і БД генерує унікальні значення
    для поля на основі цієї послідовності. Ви можете впливати на генерацію, 
    ініціалізувати послідовність з певного значення і отримувати значення id перед
    вставкою. Використання послідовностей може бути ефективним, оскільки значення 
    генеруються безпосередньо БД і не потребують блокування таблиць.</gpt> 
    
    В даному випадку йде проста генерація: 1, 2, 3, 4, ...
    */
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
