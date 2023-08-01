package net.kiranatos.repositories;

import net.kiranatos.entities.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
/* Щоб оперувати сутністями в проекті використовують "репозиторій".
   Для репозиторію необхідно вказати з якою сутністю(FruitEntity) він повинен працювати
   і тип даних для поля id цієї сутності, в даному випадку Integer*/
}
