package net.kiranatos.repositories;

import java.util.List;
import java.util.Optional;
import net.kiranatos.entities.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
    List<FruitEntity> findByFruitName(String fruitName);
    /* Крім find…, існують також ключові слова: get…, query…, read… — всі вони мають однакове значення.
    Мажна також писати findAll…, findUsers…, findUser…. Всі ці варанти працюють однаково:    
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
    */
        
    Optional<FruitEntity> getByFruitName(String fruitName);
    FruitEntity readByFruitName(String fruitName);
    /*Повертаємий тип: List<FruitEntity> можна змінити на FruitEntity чи Optional<FruitEntity>, але у випадку, якщо буде більше одного елемента, буде викинуто NonUniqueResultException

    Все возможные возвращаемые типы есть в документации. https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-return-types */
    
    
    
    /*Ограничение количества: findFirst

Зато можно выбрать только первую запись:
Optional<User> findFirstByName(String name);

И вышеприведенный метод не выбросит исключений.

Выбрать первые N записей (например, 2) можно так:
List<User> findFirst2ByName(String name);

Генерируемый SQL:
select user0_.id as id1_1_, user0_.name as name2_1_
    from user user0_ 
where user0_.name=? limit ?*/
    
}
