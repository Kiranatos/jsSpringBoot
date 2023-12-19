package net.kiranatos.services.bidir.mto;

import net.kiranatos.model.bidir.mto.Planet;
import net.kiranatos.repositories.bidir.mto.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void save(Planet planet) {
        planetRepository.save(planet);
    }
}
