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
    private final String[] arrFruits = new String[]{"Apple", "Orange", "Banana", "Mango", "Strawberry", "Pineapple", "Watermelon", "Kiwi", "Grape", "Pear", "Peach", "Pea", "Cherry"};
    private final String[] arrProviders = new String[]{"Apple Provider", "Orange Provider", "Banana Provider", "Mango Provider", "Strawberry Provider", "Pineapple Provider", "Watermelon Provider", "Kiwi Provider", "Grape Provider", "Pear Provider", "Peach Provider", "Pea Provider", "Cherry Provider"};

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<<RUN CommandLineRunner>>> ");

        initFruits(arrFruits);
        initProviders(arrProviders);

        System.out.println("\nТаблиця фруктів");
        print(fruitService.getAll());

        System.out.println("\nТаблиця постачальників");
        print(providerService.getAll());

        System.out.println("\nВсе фрукти, у яких номер постачальника між 5 та 7");
        print(fruitService.between(5, 7));

        System.out.println("\nТаблиця фруктів та їх постачальників");
        print(fruitService.joinString());

        System.out.println("\nТаблиця фруктів та їх постачальників");
        print(fruitService.joinFruit());
        
        System.out.println("\nТаблиця фруктів та їх постачальників");
        print(fruitService.joinSqlFruit());

    }

    private void initFruits(String[] fruitNames) {
        List<FruitEntity> fruitsList = new ArrayList<>();
        for (String name : fruitNames) {
            fruitsList.add(
                    // Завдяки @Accessors(chain = true) в entities ми можемо заповнити (проініціалізувати) List наступним чином:
                    new FruitEntity()
                            .setFruitName(name)
                            .setProviderCode(Math.abs(new Random().nextInt() % 10)));
        }
        fruitService.saveAll(fruitsList);
    }

    private void initProviders(String[] providerNames) {
        List<ProviderEntity> providersList = new ArrayList<>();
        for (String name : providerNames) {
            providersList.add(
                    new ProviderEntity()
                            .setProviderName(name));
        }
        providerService.saveAll(providersList);
    }

    private <T> void print(List<T> list) {
        for (T join : list) {
            System.out.println("\t\t " + join);
        }
    }
}
