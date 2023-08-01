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
        
    public void save(FruitEntity fruitEntity) {
        fruitRepository.save(fruitEntity);
    }
    
    public void save(FruitEntity[] fruitEntity) {
        for (FruitEntity f : fruitEntity) {
            save(f);
        }        
    }
    
    public void save(List<FruitEntity>fruitEntity) {
        for (FruitEntity f : fruitEntity) {
            save(f);
        }        
    }
        
    public List<FruitEntity> getAll() {        
        return fruitRepository.findAll();
    }
    
    /********************************************************/
    
    public List<FruitEntity> findByName(String fruitName) {
//        return fruitRepository.findByFruitName(fruitName);
        
//        return fruitRepository.getByFruitName(fruitName);
//        return fruitRepository.queryByFruitName(fruitName);
//        return fruitRepository.readByFruitName(fruitName);
//        
//        return fruitRepository.findALLByFruitName(fruitName);
//        return fruitRepository.findAllByFruitName(fruitName);
//        return fruitRepository.findFruitEntityByFruitName(fruitName);
//        
//        return fruitRepository.findFruitByFruitName(fruitName);
//        return fruitRepository.findFruitEntitiesByFruitName(fruitName);
//        return fruitRepository.findFruitEntitysByFruitName(fruitName);
//        return fruitRepository.findSOMETHINGEntitysByFruitName(fruitName);

        return fruitRepository.findByFruitName(fruitName);

    }
    
        public FruitEntity findOneByName(String fruitName) {
//            return fruitRepository.readByFruitName(fruitName);
            return fruitRepository.getByFruitName(fruitName).get();

    }

}
