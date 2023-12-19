package net.kiranatos.services;

import java.util.List;
import net.kiranatos.entities.FacultyEntity;
import net.kiranatos.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void saveAll(List<FacultyEntity> list) {
        facultyRepository.saveAll(list);
    }

}
