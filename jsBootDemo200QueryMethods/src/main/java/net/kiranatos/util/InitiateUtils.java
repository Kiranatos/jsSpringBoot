package net.kiranatos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.services.FruitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtils implements CommandLineRunner { 

    private final FruitService fruitService;
    
    private final int nOfBD = 25;
    private final String[] arrFruits = new String[]{"Apple", "Orange", "Banana", "Mango", "Strawberry", "Pineapple", "Watermelon", "Kiwi", "Grape", "Pear", "Peach", "Pea", "Cherry"};

    public InitiateUtils(FruitService fruitService) { 
        this.fruitService = fruitService;
    }

    @Override 
    public void run(String... args) throws Exception {
        System.out.println("\n\n <<<RUN CommandLineRunner in InitiateUtils class>>> " + Arrays.toString(args)); 
               
        System.out.println("\n Intialization DB with fruits...");
        init();

        System.out.println("\t Geting all fruits from DB:");                
        print(fruitService.getAll());
            
        System.out.println("\n ============= Demonstration #1 ============= ");
        System.out.println("\t Find all elements in DB with name `Cherry` ");
        print(fruitService.findByName("Cherry"));
             
        System.out.println("\n ============= Demonstration #2 ============= ");
        System.out.println("\t Find one element in DB with name `Cactus`.\n\t Unsafe variant, possible exception if more than one element. ");
        fruitService.save(new FruitEntity()
                .setFruitName("Cactus")
                .setProviderCode(1000));        
        System.out.println("\t\tfindOneByName: " + fruitService.findOneByName("Cactus"));
        
        System.out.println("\n ============= Demonstration #3 ============= ");
        System.out.println("\t Find one or more elements in DB with name `Strawberry` and `Banana`.\n\t Safe variant, no exception if more than one element.\n\t Обмеження кількості через findFirst.");
        System.out.println("\t\t findFirstByFruitName: " + fruitService.findFirstByName("Strawberry"));
        System.out.println("\t\t findThreeByName: ");
        print(fruitService.findThreeByName("Banana"));
        
        System.out.println("\n ============= Demonstration #5 ============= ");
        System.out.println("\t Find elements in DB that start with name `Pea`. ");
        print(fruitService.findStartsWith("Pea"));    
        
        System.out.println("\n ============= Demonstration #6 ============= ");
        System.out.println("\t Find elements in DB that have Provider Code greater then 200. ");
        print(fruitService.findEntitiesGreaterThan(200)); 
    }
    
    private static <T> void print(List<T> list) {
        for (T t : list) {
            System.out.println("\t\t " + t);
        } 
    }   
    
    private void init() {
        List<FruitEntity> listFruits = new ArrayList<>();
        for (int i = 0; i < nOfBD; i++) {
            listFruits.add(
                    new FruitEntity()
                            .setFruitName(getRandomElementFromMatrix(arrFruits))
                            .setProviderCode(getRandomFromZeroToN(10 * nOfBD))
            );
        }
        fruitService.save(listFruits);     
    }
    
    private static int getRandomFromZeroToN(int n) {
        return (int) (Math.random() * n);
    }
    
    private static <T> T getRandomElementFromMatrix(T[] matrix) {
        int index = (int) (Math.random() * matrix.length);
        return matrix[index];
    }
}