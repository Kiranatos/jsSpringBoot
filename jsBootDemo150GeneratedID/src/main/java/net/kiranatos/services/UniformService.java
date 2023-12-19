package net.kiranatos.services;


import java.util.List;
import net.kiranatos.entities.UniformEntity;

import net.kiranatos.repositories.UniformRepository;
import org.springframework.stereotype.Service;

@Service
public class UniformService {

    private final UniformRepository uniformRepository;

    public UniformService(UniformRepository uniformRepository) {
        this.uniformRepository = uniformRepository;
    }   
    
    public void saveAll(List<UniformEntity> list) {
        uniformRepository.saveAll(list);
    }    
}
