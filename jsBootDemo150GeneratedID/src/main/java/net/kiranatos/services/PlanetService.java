package net.kiranatos.services;

import java.util.List;
import net.kiranatos.entities.PlanetEntity;
import net.kiranatos.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void saveAll(List<PlanetEntity> list) {
        planetRepository.saveAll(list);
    }

}
