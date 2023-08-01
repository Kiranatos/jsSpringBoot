package net.kiranatos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.entities.ProviderEntity;
import net.kiranatos.services.FruitService;
import net.kiranatos.services.ProviderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {

    private final FruitService fruitService;
    private final ProviderService providerService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<<RUN CommandLineRunner>>> ");

        // Завдяки @Accessors(chain = true) в entities ми можемо заповнити (проініціалізувати) List наступним чином:
        List<FruitEntity> fruit = new ArrayList<>(
                Arrays.asList(
                        new FruitEntity() 
                                .setFruitName("Apple")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit2")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit3")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit4")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit5")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit6")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit7")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit8")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit9")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10))
                )
        );

        
        List<ProviderEntity> provider = new ArrayList<>(
                Arrays.asList(
                        new ProviderEntity()
                                .setProviderName("Provider1"),
                        new ProviderEntity()
                                .setProviderName("Provider2"),
                        new ProviderEntity()
                                .setProviderName("Provider3"),
                        new ProviderEntity()
                                .setProviderName("Provider4"),
                        new ProviderEntity()
                                .setProviderName("Provider5")
                )
        );

        fruitService.saveAll(fruit); 

        System.out.println("\nТаблиця фруктів");
        for (FruitEntity fruitEntity : fruitService.getAll()) {
            System.out.println(fruitEntity);
        }

        providerService.saveAll(provider);

        System.out.println("\nТаблиця постачальників");
        for (ProviderEntity providerEntity : providerService.getAll()) {
            System.out.println(providerEntity);
        }
        
        System.out.println("\nВсе фрукти, у яких номер постачальника між 5 та 7");
        for (FruitEntity fruitEntity : fruitService.between(5, 7)) {
            System.out.println(fruitEntity);
        }
    }
}
