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
               
        FruitEntity[] fruitEntityMatrix = { 
            new FruitEntity()
                .setFruitName("Apple")
                .setProviderCode(1),
            new FruitEntity()
                .setFruitName("Orange")
                .setProviderCode(2),
            new FruitEntity()
                .setFruitName("Mango")
                .setProviderCode(3),
            new FruitEntity()
                .setFruitName("Cherry")
                .setProviderCode(4),
            new FruitEntity()
                .setFruitName("Cherry")
                .setProviderCode(4),
            new FruitEntity()
                .setFruitName("Cherry")
                .setProviderCode(40),
            new FruitEntity()
                .setFruitName("Avocado")
                .setProviderCode(5)
        };
        
        fruitService.save(fruitEntityMatrix);

        List<FruitEntity> all = fruitService.getAll();

        for (FruitEntity entity : all) {
            System.out.println(entity);
        }
        
        System.out.println(" ===== MY TESTINGS: ===== ");
        for (FruitEntity fe : fruitService.findByName("Cherry") ) {
            System.out.println("findByName: " + fe);
        }
        
        System.out.println("findOneByName: " + fruitService.findOneByName("Apple"));
    }
}