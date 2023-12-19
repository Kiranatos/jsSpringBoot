package net.kiranatos.services;

import java.util.List;
import net.kiranatos.entities.AnimalEntity;
import net.kiranatos.entities.DrinkEntity;
import net.kiranatos.repositories.AnimalRepository;
import net.kiranatos.repositories.DrinkRepository;
import net.kiranatos.repositories.FruitRepository;
import net.kiranatos.repositories.PlanetRepository;
import net.kiranatos.repositories.PlantRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void saveAll(List<AnimalEntity> list) {
        animalRepository.saveAll(list);
    }

}
