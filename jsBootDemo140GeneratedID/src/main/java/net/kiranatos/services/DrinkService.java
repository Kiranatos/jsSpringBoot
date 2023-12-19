package net.kiranatos.services;

import java.util.List;
import net.kiranatos.entities.DrinkEntity;
import net.kiranatos.repositories.DrinkRepository;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }       
        
    public void saveAll(List<DrinkEntity> list) {
        drinkRepository.saveAll(list);
    }
}
