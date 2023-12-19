package net.kiranatos.services.unidir.mto;

import net.kiranatos.model.unidir.mto.School;
import net.kiranatos.repositories.unidir.mto.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    
    public void save(School school) {
        schoolRepository.save(school);
    }

}
