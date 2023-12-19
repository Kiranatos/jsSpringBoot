package net.kiranatos.services;

import java.util.List;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.repositories.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveAll(List<FruitEntity> list) {
        fruitRepository.saveAll(list);
    }

}
