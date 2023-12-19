package net.kiranatos.repositories.unidir.oto;

import net.kiranatos.model.unidir.oto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
