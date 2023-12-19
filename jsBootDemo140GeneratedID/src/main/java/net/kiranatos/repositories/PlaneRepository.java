package net.kiranatos.repositories;

import net.kiranatos.entities.PlaneEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<PlaneEntity, Long> {
}
