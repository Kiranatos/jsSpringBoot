package net.kiranatos.repositories;

import net.kiranatos.entities.UniformEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniformRepository extends JpaRepository<UniformEntity, Long> {
}
