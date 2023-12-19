package net.kiranatos.repositories;

import java.util.List;
import java.util.Optional;
import net.kiranatos.entities.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Відображення в консолі запросів, сгенерованих Spring Data, відбувається завдяки spring.jpa.show-sql=true в файлі application.properties.
Тому якщо потрібно, можна переглянути запрос наприклад для Demonstration #3 він матиме вигляд:
select f1_0.id_fruit,f1_0.fruit_name,f1_0.provider_code from fruit_table f1_0 where f1_0.fruit_name=? fetch first ? rows only

*/

@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
    
    /* ============= Demonstration #1 ============= */
    /* Крім find…, існують також ключові слова: get…, query…, read… — всі вони мають однакове значення.
    Мoжна також писати findAll…, findUsers…, findUser…. Всі ці варіанти працюють однаково:    
    List<FruitEntity> getByFruitName(String fruitName);
    List<FruitEntity> queryByFruitName(String fruitName);
    List<FruitEntity> readByFruitName(String fruitName);
    
    List<FruitEntity> findALLByFruitName(String fruitName);
    List<FruitEntity> findAllByFruitName(String fruitName);
    List<FruitEntity> findFruitEntityByFruitName(String fruitName);
    List<FruitEntity> findFruitByFruitName(String fruitName);
    List<FruitEntity> findFruitEntitiesByFruitName(String fruitName);
    List<FruitEntity> findFruitEntitysByFruitName(String fruitName);
    List<FruitEntity> findSOMETHINGEntitysByFruitName(String fruitName); 
    
    А ось так не спрацює:
    List<FruitEntity> findByName(String fruitName);
    Тому що в сутності FruitEntity назва поля fruitName, а не name.   */
    List<FruitEntity> findByFruitName(String fruitName);
            
    /* ============= Demonstration #2 ============= */
    /*Повертаємий тип: List<FruitEntity> можна змінити на FruitEntity чи Optional<FruitEntity>, 
    але у випадку, якщо буде більше одного елемента, в обох випадках станеться NonUniqueResultException

    Все возможные возвращаемые типы есть в документации:
        Знайти статью на сайті docs.spring.io з заголовками типу: "Repository query return types" або "Repository query keywords"
    */
    Optional<FruitEntity> getByFruitName(String fruitName);
    FruitEntity readByFruitName(String fruitName);
    
    /* ============= Demonstration #3 ============= */
    /* Обмеження кількості через findFirst. Завдяки цьому виключенння не буде викинуто.
    Можна вибрати тільки первший запис:   */    
    Optional<FruitEntity> findFirstByFruitName(String fruitName);
    // або N записів:
    List<FruitEntity> findFirst3ByFruitName(String fruitName);
        
    /* ============= Demonstration #5 ============= */
    List<FruitEntity> findByFruitNameIsStartingWith(String partOfFruitName);   
    List<FruitEntity> findByFruitNameStartingWith(String partOfFruitName);
    List<FruitEntity> findByFruitNameStartsWith(String partOfFruitName);
    List<FruitEntity> findDistinctByFruitNameStartsWith(String partOfFruitName);
    List<FruitEntity> findDistinctEntitiesByFruitNameStartsWith(String partOfFruitName);
    
    /* ============= Demonstration #6 ============= */    
    List<FruitEntity> findDistinctByProviderCodeIsGreaterThan(Integer n);
    List<FruitEntity> findByproviderCodeIsGreaterThan(Integer n);
    
    
}
