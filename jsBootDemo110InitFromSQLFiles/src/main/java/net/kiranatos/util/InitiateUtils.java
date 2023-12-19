package net.kiranatos.util;

import java.util.Arrays;
import java.util.List;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.services.FruitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtils implements CommandLineRunner { 

    private final FruitService fruitService;

    public InitiateUtils(FruitService fruitService) { 
        this.fruitService = fruitService;
    }

    @Override 
    public void run(String... args) throws Exception {
        System.out.println(" <<<RUN CommandLineRunner>>> " + Arrays.toString(args)); 
       
        FruitEntity fruitEntity1 = new FruitEntity();
        fruitEntity1.setFruitName("Apple Util");
        fruitEntity1.setProviderCode(1);

        FruitEntity fruitEntity2 = new FruitEntity();
        fruitEntity2.setFruitName("Orange Util");
        fruitEntity2.setProviderCode(2);

        FruitEntity fruitEntity3 = new FruitEntity();
        fruitEntity3.setFruitName("Mango Util");
        fruitEntity3.setProviderCode(3);
        
        fruitService.save(fruitEntity1);
        fruitService.save(fruitEntity2);
        fruitService.save(fruitEntity3);

        List<FruitEntity> all = fruitService.getAll();

        for (FruitEntity entity : all) {
            System.out.println(entity);
        }
    }
}