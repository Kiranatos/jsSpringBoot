package net.kiranatos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.kiranatos.entities.AnimalEntity;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.entities.DrinkEntity;
import net.kiranatos.entities.FacultyEntity;
import net.kiranatos.entities.FeedbackEntity;
import net.kiranatos.entities.PlaneEntity;
import net.kiranatos.entities.PlanetEntity;
import net.kiranatos.entities.PlantEntity;
import net.kiranatos.entities.UniformEntity;
import net.kiranatos.repositories.AnimalRepository;
import net.kiranatos.repositories.DrinkRepository;
import net.kiranatos.repositories.FacultyRepository;
import net.kiranatos.repositories.FeedbackRepository;
import net.kiranatos.repositories.FruitRepository;
import net.kiranatos.repositories.PlanetRepository;
import net.kiranatos.repositories.PlantRepository;
import net.kiranatos.repositories.PlaneRepository;
import net.kiranatos.repositories.UniformRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtils implements CommandLineRunner {

    private final AnimalRepository animalRepository;
    private final DrinkRepository drinkRepository;
    private final FacultyRepository facultyRepository;
    private final FeedbackRepository feedbackRepository;    
    private final FruitRepository fruitRepository;
    private final PlanetRepository planetRepository;
    private final PlantRepository plantRepository;
    private final PlaneRepository planeRepository;
    private final UniformRepository uniformRepository;

    public InitiateUtils(AnimalRepository animalRepository, 
            DrinkRepository drinkRepository, 
            FruitRepository fruitRepository, 
            FacultyRepository facultyRepository, 
            FeedbackRepository feedbackRepository, 
            PlanetRepository planetRepository, 
            PlantRepository plantRepository,
            PlaneRepository planeRepository,
            UniformRepository uniformRepository) {
        this.animalRepository = animalRepository;
        this.drinkRepository = drinkRepository;
        this.facultyRepository = facultyRepository;
        this.feedbackRepository = feedbackRepository;
        this.fruitRepository = fruitRepository;
        this.planetRepository = planetRepository;
        this.plantRepository = plantRepository;
        this.planeRepository = planeRepository;
        this.uniformRepository = uniformRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<<RUN CommandLineRunner>>> " + Arrays.toString(args));

        String[] arrAnimals = new String[]{"Cow", "Lion", "Hen", "Rabbit",
            "Eagle", "Elephant", "Frog", "Monkey"};

        String[] arrDrinks = new String[]{"Juice", "Martini", "Summer Breeze", "Citrus Splash",
            "Midnight Mocha", "Tropical Sunset", "Berry Bliss", "Pineapple Paradise",
            "Caramel Dream", "Cherry Fizz", "Vanilla Sky", "Minty Mojito"};
        
        String[] arrFaculties = new String[]{"FAEN", "FIOT", "FEM", "FTM", "FEA", "FIST", "FMM", 
            "FBF", "FSP", "FRI"};
        
        String[] arrFeedbacks = new String[]{"Text 0", "Text 1", "Text 2", "Text 3", "Text 4", 
            "Text 5", "Text 6", "Text 7", "Text 8", "Text 9", "Text A", "Text B"};
        
        String[] arrFruits = new String[]{"Banana", "Water Melon", "Melon", "Ananas",
            "Apple", "Kiwi", "Pomelo", "Orange"};

        String[] arrPlanets = new String[]{"Mercury", "Venos", "Earth", "Mars",
            "Faeton", "Jupiter", "Saturn", "Neptune", "Kepler-186f", "Kepler-442b",
            "Kepler-22b", "Kepler-186c"};

        String[] arrPlants = new String[]{"Nettle", "Rose", "Sunflower", "Daffodil",
            "Tulip", "Cactus", "Lavender", "Daisy", "Oak tree", "Maple tree", "Palm tree"};
        
        String[] arrPlanes = new String[]{"plane A", "plane B", "plane C", "plane D",
            "plane E", "plane F", "plane G", "plane H", "plane I", "plane G", "plane K"};
        
        String[] arrUniforms = new String[]{"police", "doctor", "fireman", "cosplay",
            "nurse", "pirate", "sheepman", "sailor", "oilman", "killer",
            "millitary", "karate"};

        List<AnimalEntity> animalList = new ArrayList<>();
        for (String name : arrAnimals) {
            AnimalEntity animalEntity = new AnimalEntity();
            animalEntity.setAnimalName(name);
            animalList.add(animalEntity);
        }

        List<DrinkEntity> drinkList = new ArrayList<>();
        for (String name : arrDrinks) {
            DrinkEntity drinkEntity = new DrinkEntity();
            drinkEntity.setDrinkName(name);
            drinkList.add(drinkEntity);
        }

        List<FacultyEntity> facultiesList = new ArrayList<>();
        for (String name : arrFaculties) {
            FacultyEntity f = new FacultyEntity();
            f.setFacultyName(name);
            facultiesList.add(f);
        }
        
        List<FeedbackEntity> feedbackList = new ArrayList<>();
        for (String text : arrFeedbacks) {
            FeedbackEntity f = new FeedbackEntity();
            f.setFeedbackText(text);
            feedbackList.add(f);
        }
        
        List<FruitEntity> fruitList = new ArrayList<>();
        for (String name : arrFruits) {
            FruitEntity fruitEntity = new FruitEntity();
            fruitEntity.setFruitName(name);
            fruitList.add(fruitEntity);
        }

        List<PlanetEntity> planetList = new ArrayList<>();
        for (String name : arrPlanets) {
            PlanetEntity planetEntity = new PlanetEntity();
            planetEntity.setPlanetName(name);
            planetList.add(planetEntity);
        }

        List<PlantEntity> plantList = new ArrayList<>();
        for (String name : arrPlants) {
            PlantEntity plantEntity = new PlantEntity();
            plantEntity.setPlantName(name);
            plantList.add(plantEntity);
        }
        
        List<PlaneEntity> planeList = new ArrayList<>();
        for (String name : arrPlanes) {
            PlaneEntity planeEntity = new PlaneEntity();
            planeEntity.setPlaneName(name);
            planeList.add(planeEntity);
        }
        
        List<UniformEntity> uniformList = new ArrayList<>();
        for (String name : arrUniforms) {
            UniformEntity uEntity = new UniformEntity();
            uEntity.setUniformName(name);
            uEntity.setColor("black");
            uniformList.add(uEntity);
        }

        animalRepository.saveAll(animalList);
        drinkRepository.saveAll(drinkList);
        facultyRepository.saveAll(facultiesList);
        feedbackRepository.saveAll(feedbackList);
        fruitRepository.saveAll(fruitList);
        planetRepository.saveAll(planetList);
        plantRepository.saveAll(plantList);
        planeRepository.saveAll(planeList);
        uniformRepository.saveAll(uniformList);
    }
}
