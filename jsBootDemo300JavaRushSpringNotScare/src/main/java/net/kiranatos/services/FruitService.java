package net.kiranatos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.repositories.FruitRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public Optional<FruitEntity> getById(Integer id) {
        return fruitRepository.findById(id);
    }

    public void delById(Integer id) {
        fruitRepository.deleteById(id);
    }

    public Boolean exist(Example<? extends FruitEntity> example) {
        return fruitRepository.exists(example);
    }

    public void save(FruitEntity fruitEntity) {
        fruitRepository.save(fruitEntity);
    }

    public List<FruitEntity> getAll() {
        return fruitRepository.findAll();
    }

    public void saveAll(List<FruitEntity> fruits) {
        fruitRepository.saveAll(fruits);
    }

    public List<FruitEntity> between(Integer from, Integer to) {
        List<FruitEntity> list = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            list.addAll(fruitRepository.findByProviderCode(i));
        }
        return list;
    }

    public List<String> joinString() {
        return fruitRepository.joinSting();
    }

    public List<FruitEntity> joinFruit() {
        return fruitRepository.joinFruit();
    }
    
    public List<String> joinSqlFruit() {
        return fruitRepository.joinSqlFruit();
    }
}
