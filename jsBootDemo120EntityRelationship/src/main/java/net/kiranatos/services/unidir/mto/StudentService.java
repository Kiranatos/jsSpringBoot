package net.kiranatos.services.unidir.mto;

import net.kiranatos.model.unidir.mto.Student;
import net.kiranatos.repositories.unidir.mto.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public void save(Student student) {
        studentRepository.save(student);
    }

}
