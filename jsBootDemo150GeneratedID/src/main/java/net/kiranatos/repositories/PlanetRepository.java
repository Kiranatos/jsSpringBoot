package net.kiranatos.repositories;

import net.kiranatos.entities.PlanetEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetEntity, Long> {
}
