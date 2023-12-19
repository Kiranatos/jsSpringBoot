package net.kiranatos.services.unidir.oto;

import net.kiranatos.model.unidir.oto.Car;
import net.kiranatos.repositories.unidir.oto.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(Car car) {
        carRepository.save(car);
    }

}
