package net.kiranatos.services;


import java.util.List;
import net.kiranatos.entities.PlantEntity;

import net.kiranatos.repositories.PlantRepository;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }   
    
    public void saveAll(List<PlantEntity> list) {
        plantRepository.saveAll(list);
    }    
}
