package net.kiranatos.util;

import java.util.Arrays;
import java.util.List;
import net.kiranatos.entities.FruitEntity;
import net.kiranatos.services.FruitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

// Нам потрібна ця утиліта, як альтернатива класу Applications, оскільки він повинен відповідати тільки за запуск програми.
/* <gpt>  CommandLineRunner надає спосіб запуску коду після того, як додаток завершить свій 
запуск і контекст Spring буде готовий до використання.
Метод void run(String... args) буде викликано автоматично після того, як додаток 
буде готовий до роботи, тобто всі біни в контексті будуть створені і налаштовані. 
В параметр args передаються аргументи командного рядка.
    Клас CommandLineRunner може бути використаний для виконання деяких задач, які 
повинні бути виконані при запуску додатку, наприклад, запуску додаткових сервісів, 
ініціалізації бази даних тощо. Цей клас можна використовувати в будь-якому 
Spring-додатку, а не тільки в додатках Spring Boot. </gpt>*/

@Service
public class InitiateUtils implements CommandLineRunner { // імплементуємо інтерфейс CommandLineRunner (командний рядок запуску)

    private final FruitService fruitService;

    public InitiateUtils(FruitService fruitService) { // injection constructor for connection between util and service
        this.fruitService = fruitService;
    }

    @Override //перевизначаємо метод який дозволить виконувати методи нашої програми під час запуску
    public void run(String... args) throws Exception {
        System.out.println(" <<<RUN CommandLineRunner>>> " + Arrays.toString(args)); // args отримані з класу Applications

        //Створюємо сутності
        FruitEntity fruitEntity1 = new FruitEntity();
        fruitEntity1.setFruitName("Apple");
        fruitEntity1.setProviderCode(1);

        FruitEntity fruitEntity2 = new FruitEntity();
        fruitEntity2.setFruitName("Orange");
        fruitEntity2.setProviderCode(2);

        FruitEntity fruitEntity3 = new FruitEntity();
        fruitEntity3.setFruitName("Mango");
        fruitEntity3.setProviderCode(3);

        //Зберігаємо до БД, кожен об'єкт окремо
        fruitService.save(fruitEntity1);
        fruitService.save(fruitEntity2);
        fruitService.save(fruitEntity3);

        //тут витягуємо базу назад
        List<FruitEntity> all = fruitService.getAll();

        for (FruitEntity entity : all) {
            System.out.println(entity);
        }
    }
}

/* Часто в прикладах клас Applications реалізує CommandLineRunner сам:

@SpringBootApplication
public class Applications implements CommandLineRunner {
    private static Logger LOG = LoggerFactory.getLogger(Applications.class);
    public static void main(String[] args) {        
        SpringApplication.run(SpringBootCommandLineRunner.class, new String[]{"ichi","ni","san"});        
    }

    @Override
    public void run(String... args) throws Exception {        
        LOG.info("ARGS : - {}", Arrays.toString(args));        
    }
} */