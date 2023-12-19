package net.kiranatos.util.unidir.oto;

import net.kiranatos.model.unidir.oto.Car;
import net.kiranatos.model.unidir.oto.ParkingSpot;

import net.kiranatos.services.unidir.oto.CarService;
import net.kiranatos.services.unidir.oto.ParkingSpotService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtilsCarAndParkingSpot implements CommandLineRunner {

    private final CarService carService;
    private final ParkingSpotService parkingSpotService;

    public InitiateUtilsCarAndParkingSpot(CarService carService, ParkingSpotService parkingSpotService) {
        this.carService = carService;
        this.parkingSpotService = parkingSpotService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Unidirectional association | @OneToOne | Car and ParkingSpot entities >>> ");

        create("Los Santos", "volvo-", 3);
        create("Paris", "mercedes-", 2);
        create("London", "toyota-", 4);
        create("Kyiv", "vaz-", 2);

    }

    private void create(String parkingSpot, String nameCar, int n) {
        ParkingSpot ps = new ParkingSpot();
        ps.setName(parkingSpot);
        parkingSpotService.save(ps);
                
        for (int i = 0; i < n; i++) {
            Car car = new Car();
            car.setName(nameCar + Math.floor(Math.random() * 1000) / 10); 
            car.setParkingSpot(ps);
            carService.save(car);
        }
    }
}
