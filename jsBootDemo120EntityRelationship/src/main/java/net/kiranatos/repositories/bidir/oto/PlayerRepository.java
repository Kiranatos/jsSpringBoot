package net.kiranatos.repositories.bidir.oto;

import net.kiranatos.model.bidir.oto.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
