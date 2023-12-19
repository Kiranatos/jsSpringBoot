package net.kiranatos.services;


import java.util.List;
import net.kiranatos.entities.PlaneEntity;

import net.kiranatos.repositories.PlaneRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }   
    
    public void saveAll(List<PlaneEntity> list) {
        planeRepository.saveAll(list);
    }    
}
