package net.kiranatos.repositories;

import java.util.List;
import net.kiranatos.entities.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/* Щоб оперувати сутністями в проекті використовують "репозиторій".
   Для репозиторію необхідно вказати з якою сутністю(FruitEntity) він повинен працювати
   і тип даних для поля id цієї сутності, в даному випадку Integer*/
@Repository
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {

    List<FruitEntity> findByProviderCode(Integer id);

    List<FruitEntity> countFruitEntityByFruitName(String fruitName);

    // JPQL
    @Query("select f.fruitName, p.providerName from  FruitEntity f left join ProviderEntity p on f.providerCode = p.id")
    List<String> joinSting();

    // JPQL
    @Query("select f from  FruitEntity f join ProviderEntity p on f.providerCode = p.id")
    List<FruitEntity> joinFruit();

    // SQL
    @Query(
            value = "select fruit_table.fruit_name, provider_table.provider_name from  fruit_table  join provider_table on fruit_table.provider_code = provider_table.id_provider",
            nativeQuery = true)
    List<String> joinSqlFruit();
}
