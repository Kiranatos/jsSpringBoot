package net.kiranatos.repositories.unidir.oto;

import net.kiranatos.model.unidir.oto.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Integer> {

}
