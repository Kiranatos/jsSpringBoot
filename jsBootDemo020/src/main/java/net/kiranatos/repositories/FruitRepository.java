package net.kiranatos.repositories;

import net.kiranatos.entities.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
/* Щоб оперувати сутністями в проекті використовують "репозиторій".
   Для репозиторію необхідно вказати з якою сутністю(FruitEntity) він повинен працювати
   і тип даних для поля id цієї сутності, в даному випадку Integer
    
   CrudRepository - базовий інтерфейс, який надає основні CRUD операції для сутностей. 
   Надає методи стандартних операцій з БД, таких як save, findById, findAll, delete, тощо.     

   JpaRepository - інтерфейс, що розширює CrudRepository та надає додаткові методи 
   для роботи з JPA-специфічними функціями. JpaRepository має методи для пагінації даних, 
   сортування, виконання JPQL (Java Persistence Query Language) запитів, а також 
   для здійснення більш специфічних запитів, які вимагають використання JPA-запитів 
   або SQL-запитів. Надає більш гнучкий спосіб взаємодії з БД.  */
}
