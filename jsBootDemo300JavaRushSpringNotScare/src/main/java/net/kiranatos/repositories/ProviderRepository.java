package net.kiranatos.repositories;

import net.kiranatos.entities.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity,Integer> {
}
