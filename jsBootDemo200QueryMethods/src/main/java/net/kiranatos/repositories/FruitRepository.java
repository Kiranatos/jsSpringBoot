package net.kiranatos.repositories;

import java.util.List;
import java.util.Optional;
import net.kiranatos.entities.FruitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Відображення в консолі запросів, сгенерованих Spring Data, відбувається завдяки spring.jpa.show-sql=true в файлі application.properties.
Тому якщо потрібно, можна переглянути запрос наприклад для Demonstration #3 він матиме вигляд:
select f1_0.id_fruit,f1_0.fruit_name,f1_0.provider_code from fruit_table f1_0 where f1_0.fruit_name=? fetch first ? rows only

*/

@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
    
    /* ============= Demonstration #1 [ find…By, read…By, get…By, query…By, search…By, stream…By ] ============= */
    /* Крім find…, існують також ключові слова: get…, query…, read… — всі вони мають однакове значення.
    Мoжна також писати findAll…, findUsers…, findUser…. Всі ці варіанти працюють однаково:    
    List<FruitEntity> getByFruitName(String fruitName);
    List<FruitEntity> queryByFruitName(String fruitName);
    List<FruitEntity> readByFruitName(String fruitName);
        
    List<FruitEntity> findAllByFruitName(String fruitName);
    List<FruitEntity> findFruitEntityByFruitName(String fruitName);
    List<FruitEntity> findFruitByFruitName(String fruitName);
    List<FruitEntity> findFruitEntitiesByFruitName(String fruitName);
    List<FruitEntity> findFruitEntitysByFruitName(String fruitName);
    List<FruitEntity> findSOMETHINGEntitysByFruitName(String fruitName); 
    
    Is or Equals for readability:
    List<User> findByNameIs(String name);
    List<User> findByNameEquals(String name);
    List<User> findByNameIsNot(String name);
    
    А ось так не спрацює:
    List<FruitEntity> findByName(String fruitName);
    Тому що в сутності FruitEntity назва поля fruitName, а не name.
    
    The first part — such as "find" — is the introducer, and the rest — such as "ByName" — is the criteria.
    
    Тобто в назві findSOMETHINGEntitysByFruitName
            find...By - зарезервовані слова
            SOMETHINGEntitys - можна писати будь-що, або взагалі не писати.
            FruitName - поле в сутності    */
    List<FruitEntity> findByFruitName(String fruitName);
            
    /* ============= Demonstration #2 returned type ============= */
    /*Повертаємий тип: List<FruitEntity> можна змінити на FruitEntity чи Optional<FruitEntity>, 
    але у випадку, якщо буде більше одного елемента, в обох випадках станеться NonUniqueResultException

    Все возможные возвращаемые типы есть в документации:
        Знайти статью на сайті docs.spring.io з заголовками типу: "Repository query return types" або "Repository query keywords"
    */
    Optional<FruitEntity> getByFruitName(String fruitName);
    FruitEntity readByFruitName(String fruitName);
    
    /* ============= Demonstration #3 findFirst ============= */
    /* Обмеження кількості через findFirst. Завдяки цьому виключенння не буде викинуто.
    Можна вибрати тільки первший запис:   */    
    Optional<FruitEntity> findFirstByFruitName(String fruitName);
    // або N записів:
    List<FruitEntity> findFirst3ByFruitName(String fruitName);
    
    /* using Distinct, First or Top we can remove duplicates or limit our result set:
    List<User> findTop3ByName() */
        
    /* ============= Demonstration #5 ============= */
    List<FruitEntity> findByFruitNameIsStartingWith(String partOfFruitName);   
    List<FruitEntity> findByFruitNameStartingWith(String partOfFruitName);
    List<FruitEntity> findByFruitNameStartsWith(String partOfFruitName);
    List<FruitEntity> findDistinctByFruitNameStartsWith(String partOfFruitName);
    List<FruitEntity> findDistinctEntitiesByFruitNameStartsWith(String partOfFruitName);    
    /*          Similarity Condition Keywords
    List<User> findByNameStartingWith(String prefix); = WHERE name LIKE ‘value%’
    List<User> findByNameEndingWith(String suffix);
    List<User> findByNameContaining(String infix);
    Note that all conditions above are called predefined pattern expressions. So, we don’t need to add % operator inside the argument when these methods are called.

    But say we need to fetch the users whose names start with an 'a', contain 'b' and end with 'c'.
    We use 'Like' keyword:    
    List<User> findByNameLike(String likePattern);
    where
    String likePattern = "a%b%c";
    userRepository.findByNameLike(likePattern);        */
    
    /* ============= Demonstration #6 ============= */    
    List<FruitEntity> findDistinctByProviderCodeIsGreaterThan(Integer n);
    List<FruitEntity> findByproviderCodeIsGreaterThan(Integer n);
    /*          Comparison Condition Keywords
    List<User> findByAgeLessThan(Integer age);
    List<User> findByAgeLessThanEqual(Integer age);
    List<User> findByAgeGreaterThan(Integer age);
    List<User> findByAgeGreaterThanEqual(Integer age);
    List<User> findByAgeBetween(Integer startAge, Integer endAge);
    List<User> findByAgeIn(Collection<Integer> ages); - We can also supply a collection of ages to match against using In.
    List<User> findByBirthDateAfter(ZonedDateTime birthDate);
    List<User> findByBirthDateBefore(ZonedDateTime birthDate);    */
    
    /* ============= Demonstration #7 AND ============= */
    List<FruitEntity> findByFruitNameStartsWithAndProviderCodeIsGreaterThan(String partOfFruitName, Integer n);
    /* Була помилка: після And, By  не ставиться, бо тоді Хібернейт шукає поле byProviderCode. 
    
    List<User> findByNameOrAge(String name, Integer age);
    List<User> findByNameOrAgeAndActive(String name, Integer age, Boolean active);
    The precedence order is And then Or, just like Java.    
    */
    
    /* ============= Demonstration #8 OR ============= */
    List<FruitEntity> findByFruitNameIsEndingWithOrProviderCodeLessThanEqual(String partOfFruitName, Integer n);
    
    /* ============= Demonstration #9 Iterable ============= */
    List<FruitEntity> findByFruitNameIn(Iterable names);
    /* Бажано параметр робити саме Iterable, а не Set чи List, щоб було меньше зайвих перетворень. */
    
    /* ============= Demonstration #10 Pagination ============= */
    Page<FruitEntity> findByFruitName(String name, Pageable pageable);    
    /*    Pagination
    Можна створювати запити для посторінкового отримання сутностей:
        Page<User> findByName(String name, Pageable pageable);
    Варто зазначити, що метод посторінкового отримання всіх сутностей вже є в PagingAndSortingRepository:
        public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
            Page<T> findAll(Pageable pageable);
        }  */
    
    /* ============= Demonstration #11 orderBy sort ============= */
    List<FruitEntity> findByFruitNameContainingOrderByFruitNameAsc(String partOfFruitName);
    List<FruitEntity> findByFruitNameContainingOrderByProviderCodeDesc(String partOfFruitName);
    List<FruitEntity> findByFruitNameContainingOrderByFruitNameAscProviderCodeDesc(String partOfFruitName);     
    /* List<User> findByNameOrderByName(String name); - Ascending order is the default sorting option
    List<User> findByNameOrderByNameAsc(String name);
    List<User> findByNameOrderByNameDesc(String name);    */
    
    /* ============= Demonstration #12 class Sort ============= */
    List<FruitEntity> findByFruitNameContaining(String partOfFruitName, Sort sort);    
    
    /* ============= Demonstration #13 count ============= */
    int countAllByFruitName(String name);
    int countDistinctByFruitNameContaining(String partOfName);
    
    /* ============= Demonstration #14 remove/delete ============= */    
    int deleteByFruitName(String name);
    void removeSomethingByFruitNameContaining(String partOfName);
    

    /* ============= Pending next Demonstrations ============= 
    
    Note that these methods don't require a method argument.
    List<User> findByNameIsNull();
    List<User> findByNameIsNotNull();
    List<User> findByActiveTrue();
    List<User> findByActiveFalse();
    
    */    
}
