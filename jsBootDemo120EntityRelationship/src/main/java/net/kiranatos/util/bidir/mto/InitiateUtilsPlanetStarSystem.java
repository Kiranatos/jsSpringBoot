package net.kiranatos.util.bidir.mto;

import java.util.ArrayList;
import java.util.List;
import net.kiranatos.model.bidir.mto.Planet;
import net.kiranatos.model.bidir.mto.StarSystem;
import net.kiranatos.services.bidir.mto.PlanetService;
import net.kiranatos.services.bidir.mto.StarSystemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtilsPlanetStarSystem implements CommandLineRunner {

    private final PlanetService planetService;
    private final StarSystemService starSystemService;

    public InitiateUtilsPlanetStarSystem(PlanetService planetService, StarSystemService starSystemService) {
        this.planetService = planetService;
        this.starSystemService = starSystemService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Bidirectional association | Planet and StarSystem entities >>> ");

        String[] arrPlanets = new String[]{"Mercury", "Venos", "Earth", "Mars",
            "Faeton", "Jupiter", "Saturn", "Neptune", "Uran", "Pluto"};

        String[] alphaCentauriPlanets = new String[]{"Alpha Centauri b", "Alpha Centauri c", "Alpha Centauri d"};

        String[] siriusPlanets = new String[]{"Sirius A I", "Sirius A II", "Sirius B I", "Sirius B II"};

        String[] proximaCentauriPlanets = new String[]{"Proxima Centauri b", "Proxima Centauri c"};

        createSystem("Solar", arrPlanets);
        createSystem("Alpha Centauri", alphaCentauriPlanets);
        createSystem("Sirius", siriusPlanets);
        createSystem("Proxima Centauri", proximaCentauriPlanets);

    }

    private void createSystem(String nameOfSystem, String[] planets) {
        StarSystem ss = new StarSystem();
        ss.setName(nameOfSystem);

        List<Planet> listPlanets = new ArrayList<>();
        for (String planet : planets) {
            Planet p = new Planet();
            p.setName(planet);
            p.setStarSystem(ss);
            listPlanets.add(p);
        }

        ss.setPlanets(listPlanets);
        starSystemService.save(ss);
        for (Planet planet : listPlanets) {
            planetService.save(planet);
        }
    }

}
