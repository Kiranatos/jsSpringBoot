package net.kiranatos.repositories.unidir.mto;

import net.kiranatos.model.unidir.mto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
