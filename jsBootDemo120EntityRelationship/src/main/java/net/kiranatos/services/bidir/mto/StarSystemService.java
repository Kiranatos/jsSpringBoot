package net.kiranatos.services.bidir.mto;

import net.kiranatos.model.bidir.mto.StarSystem;
import net.kiranatos.repositories.bidir.mto.StarSystemRepository;
import org.springframework.stereotype.Service;

@Service
public class StarSystemService {

    private final StarSystemRepository starSystemRepository;

    public StarSystemService(StarSystemRepository starSystemRepository) {
        this.starSystemRepository = starSystemRepository;
    }

    public void save(StarSystem starSystem) {
        starSystemRepository.save(starSystem);
    }
}
