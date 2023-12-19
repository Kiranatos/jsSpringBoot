package net.kiranatos.util.unidir.mto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.kiranatos.model.unidir.mto.School;
import net.kiranatos.model.unidir.mto.Student;

import net.kiranatos.services.unidir.mto.SchoolService;
import net.kiranatos.services.unidir.mto.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;



@Service
public class InitiateUtilsSchoolStudent implements CommandLineRunner {

    private final SchoolService schoolService;
    private final StudentService studentService;

    public InitiateUtilsSchoolStudent(SchoolService schoolService, StudentService studentService) {
        this.schoolService = schoolService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {        
        System.out.println(" <<< Unidirectional association | @ManyToOne | Student and School entities >>> " + Arrays.toString(args));
        
        create("KPI", "John-", 3);
        create("NAU", "Marina-", 5);
        create("KISI", "Yulia-", 4);
    }
    
    private void create(String nameSchool, String nameStudent, int n) {
        School sch = new School();
        sch.setName(nameSchool);
        schoolService.save(sch);       
        
        for (int i = 0; i < n; i++) {
            Student st = new Student();
            st.setName(nameStudent + Math.floor(Math.random()*1000)/10);    
            st.setSchool(sch);
            studentService.save(st);
        }   
    }
}
