package net.kiranatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Applications {
    public static void main(String[] args) {        
        SpringApplication.run(Applications.class);
    }
}

/*
SELECT * FROM BANK_ACC ; 
SELECT * FROM BANK_USER ;

    Цей проект створенний на основі частини проекту jsBootDemo120EntityRelationship, 
а саме bidirectional many-to-one relationship.

Tasks:
A)      Цей таск: 1) завдання розібратись в майбутньому глибше; 2) опис проблеми; 3) мої дії. 
    Так як в статті "Spring Data JPA: запросы, генерируемые по имени метода" / https://sysout.ru/spring-data-jpa-zaprosy-generiruemye-po-imeni-metoda/
    використовувались private Set<Account> accounts; замість List, всюди поставив Set.
    Через це падала помилка org.hibernate.LazyInitializationException. Після гугління знайшлося рішення:
    Проблема в жадності коллекцій, треба поставити fetch в классі User:
            @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
        Шляхом моїх подальших Set-List жонглювань, я вирахував, що помилка виникає в {1} (класи AccountService та InitiateUtils),
    при List працює нормально, а при Set падає, якщо не поставить fetch в классі User.
        Коллекції Set та List в {2} (класи User, UserService та InitiateUtils) можна міняти вільно,
    вони не падали з помилкою і не потребували fetch.
        Базову копію цього проекту з назвою jsBootDemo201QueryMethodsBiDirBase збережу в хSANDBOX на випадок моъх майбутніх досліджень по цьому питанню.
    
B)  Task to make bug output in class UserRepository, Demonstration #1B.

C)  Прочитати і законспектувати статью, якщо є що цікаве:
    NonUniqueResultException и NoResultException
    https://sysout.ru/nonuniqueresultexception-i-noresultexception/

D)  Прочитати і законспектувати статьї, якщо є що цікаве:    
    Supported Query Return Types
    https://docs.spring.io/spring-data/jpa/reference/repositories/query-return-types-reference.html
    Якщо посилання знову зміняться, то загуглити їх, або подібні їм через їх назви.
    Вивчити і розібрати ключові слова для побудови методів в репозиторіях та можливі повертаємі типи на прикладах.

Task 50: проекти jsBootDemo200QueryMethods, jsBootDemo201QueryMethodsBiDir і jsBootDemo300JavaRushSpringNotScare можуть мати спільні Task, що перетинаються.
    
*/