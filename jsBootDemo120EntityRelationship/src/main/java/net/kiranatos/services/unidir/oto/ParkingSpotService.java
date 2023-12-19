package net.kiranatos.services.unidir.oto;

import net.kiranatos.model.unidir.oto.ParkingSpot;
import net.kiranatos.repositories.unidir.oto.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public void save(ParkingSpot parkingSpot) {
        parkingSpotRepository.save(parkingSpot);
    }

}
