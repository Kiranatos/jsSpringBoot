package net.kiranatos.services.bidir.mtm;

import net.kiranatos.model.bidir.mtm.Pupil;
import net.kiranatos.repositories.bidir.mtm.PupilRepository;
import org.springframework.stereotype.Service;

@Service
public class PupilService {

    private final PupilRepository pupilRepository;

    public PupilService(PupilRepository pupilRepository) {
        this.pupilRepository = pupilRepository;
    }

    public void save(Pupil pupil) {
        pupilRepository.save(pupil);
    }
}
