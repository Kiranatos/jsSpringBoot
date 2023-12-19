package net.kiranatos.repositories.bidir.mto;

import net.kiranatos.model.bidir.mto.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarSystemRepository extends JpaRepository<StarSystem, Integer> {

}
