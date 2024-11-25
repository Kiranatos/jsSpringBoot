package net.kiranatos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.services.FruitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

        System.out.println("\n ============= Demonstration #0 methods that exist in repository from the beginning ============= ");
        System.out.println("\t Geting all fruits from DB:");                
        print(fruitService.getAll());
            
        System.out.println("\n ============= Demonstration #1 [ find…By, read…By, get…By, query…By, search…By, stream…By ] ============= ");
        System.out.println("\t Find all elements in DB with name `Cherry` ");
        print(fruitService.findByName("Cherry"));
             
        System.out.println("\n ============= Demonstration #2 returned type ============= ");
        System.out.println("\t Find one element in DB with name `Cactus`.\n\t Unsafe variant, possible exception if more than one element. ");
        fruitService.save(new FruitEntity()
                .setFruitName("Cactus")
                .setProviderCode(1000));        
        System.out.println("\t\tfindOneByName: " + fruitService.findOneByName("Cactus"));
        
        System.out.println("\n ============= Demonstration #3 findFirst ============= ");
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
        
        System.out.println("\n ============= Demonstration #7 AND ============= ");
        System.out.println("\t Find elements in DB that start with `C` AND have Provider Code greater then 100. ");
        print(fruitService.findStartingWithAndGreaterThan("C", 100)); 
        
        System.out.println("\n ============= Demonstration #8 OR ============= ");        
        System.out.println("\t Find elements in DB that end with `e` OR have Provider Code less or equal 50. ");
        fruitService.save(new FruitEntity()
                .setFruitName("Passion fruit")
                .setProviderCode(50));  
        print(fruitService.findEndingWithOrLessThanEqual("e", 50)); 
        
        System.out.println("\n ============= Demonstration #9 Iterable ============= ");
        System.out.println("\t Find in DB elements: . ");
        print(fruitService.findByNames(Arrays.asList("Kiwi", "Grape", "Pear"))); 
        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Orange");
        print(fruitService.findByNames(list)); 
        
        System.out.println("\n ============= Demonstration #10 Pagination ============= ");        
        init("Clementine", 20);
        Page<FruitEntity> fruitPage = fruitService.findByName("Clementine", PageRequest.of(0, 5)); // pages start with 0
        System.out.println(".toString = " + fruitPage.toString());
        System.out.println(".getSize = " + fruitPage.getSize());
        System.out.println(".getTotalElements = " + fruitPage.getTotalElements());
        System.out.println(".getTotalPages = " + fruitPage.getTotalPages());
        System.out.println("\t Output of 0 page with 5 elements that have name `Clementine`.");
        fruitPage.stream().forEach(fruit -> System.out.println(fruit));
        System.out.println("\t Output of 2 page with 4 elements that have name `Clementine`.");
        fruitPage = fruitService.findByName("Clementine", PageRequest.of(2, 4));
        fruitPage.getContent().forEach(fruit -> System.out.println(fruit));

        System.out.println("\n ============= Demonstration #11 orderBy sort ============= ");
        init("Tangerine", 2);
        init("Grapevine", 1);
        init("Columbine", 3);
        init("Porcupine Tomato", 2);
        init("Porcupine Grass", 1);
        System.out.println("\t Find in DB elements that have `ine` in their name and sort by ascending name and descending provider code: ");
        print(fruitService.findByPartNameAndOrder("ine"));
        
        System.out.println("\n ============= Demonstration #12 class Sort ============= ");
        System.out.println("\t Find in DB elements that have `ine` in their name and sort by ascending provider code using class Sort: ");
        Sort sort = Sort.by(Sort.Direction.ASC, /*"fruitName"*/ "providerCode");
        print(fruitService.findByPartNameAndOrder("ine", sort));
        
        System.out.println("\n ============= Demonstration #13 count ============= ");        
        System.out.println("\t Elements with name 'Clementine': " + fruitService.countAllByName("Clementine"));
        System.out.println("\t Elements with 'pple' as part of name: " + fruitService.countAllBySubString("pple"));
        
        System.out.println("\n ============= Demonstration #14 remove/delete ============= ");
        System.out.println("\t Deleted elements with name 'Clementine': " + fruitService.deleteByName("Clementine"));
        System.out.println("\t Deleted elements with 'pple' as part of name.");
        fruitService.deleteBySubString("pple");        
        
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
        fruitService.saveAll(listFruits);     
    }
    
    private void init(String fruit, int n) {
        List<FruitEntity> listFruits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listFruits.add(
                    new FruitEntity()
                            .setFruitName(fruit)
                            .setProviderCode(getRandomFromZeroToN(10 * nOfBD))
            );
        }
        fruitService.saveAll(listFruits);     
    }
    
    
    private static int getRandomFromZeroToN(int n) {
        return (int) (Math.random() * n);
    }
    
    private static <T> T getRandomElementFromMatrix(T[] matrix) {
        int index = (int) (Math.random() * matrix.length);
        return matrix[index];
    }
}