package net.kiranatos.repositories.bidir.mtm;

import net.kiranatos.model.bidir.mtm.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Integer> {

}
