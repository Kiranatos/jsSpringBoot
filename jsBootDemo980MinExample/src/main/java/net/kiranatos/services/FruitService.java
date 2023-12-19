package net.kiranatos.services;

import java.util.List;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.repositories.FruitRepository;
import org.springframework.stereotype.Service;

// Так як репозиторій є інтерфейсом, що тільки оголошує методи, необхідно ще створити "сервіс", щоб ці методи реалізувати.

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) { // injection constructor for connection between repository and service
        this.fruitRepository = fruitRepository;
    }
    
    // Створюємо публічний метод (назва може бути будь-яка), на вхід приймає сутність та зберігає її в БД
    public void save(FruitEntity fruitEntity) {
        fruitRepository.save(fruitEntity); // реалізували метод репозиторію впровадженого біна
    }
    
    // Повертає всі сутності з БД
    public List<FruitEntity> getAll() {        
        return fruitRepository.findAll(); // реалізували метод репозиторію впровадженого біна
    }

}
