package net.kiranatos.repositories.unidir.mto;

import net.kiranatos.model.unidir.mto.School;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

}
