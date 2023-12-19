package net.kiranatos.repositories.bidir.mto;

import net.kiranatos.model.bidir.mto.Planet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

}
