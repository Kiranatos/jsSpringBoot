package net.kiranatos.services.bidir.mtm;

import net.kiranatos.model.bidir.mtm.Lesson;
import net.kiranatos.repositories.bidir.mtm.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public void save(Lesson lesson) {
        lessonRepository.save(lesson);
    }
}
