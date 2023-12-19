package net.kiranatos.util.bidir.mtm;

import java.util.ArrayList;
import java.util.List;
import net.kiranatos.model.bidir.mtm.Lesson;
import net.kiranatos.model.bidir.mtm.Pupil;
import net.kiranatos.services.bidir.mtm.LessonService;
import net.kiranatos.services.bidir.mtm.PupilService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtilsPupilLesson implements CommandLineRunner {

    private final LessonService lessonService;
    private final PupilService pupilService;

    public InitiateUtilsPupilLesson(LessonService lessonService, PupilService pupilService) {
        this.lessonService = lessonService;
        this.pupilService = pupilService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Bidirectional association | Pupil and Lesson entities >>> ");

        String[] pupilsNames = new String[]{"Alice", "Bob", "Charlie", "Diana", "Elena", "Frank", "Grace", "John", "Marina", "Boris", "Yulia"};
        String[] lessonsNames = new String[]{"Mathematics", "Science", "History", "Literature", "Art", "Music", "Physical Education"};

        createSchool(lessonsNames, pupilsNames);
    }

    private void createSchool(String[] lessonsArr, String[] pupilsArr) {
        List<Lesson> listLessons = new ArrayList<>();
        for (String lesStr : lessonsArr) {
            Lesson lesson = new Lesson();
            lesson.setName(lesStr);
            listLessons.add(lesson);

            //lessonService.save(lesson);
        }

        List<Pupil> listPupils = new ArrayList<>();
        for (String pupStr : pupilsArr) {
            Pupil pupil = new Pupil();
            pupil.setName(pupStr);
            pupil.setLessons(listLessons);
            listPupils.add(pupil);

            pupilService.save(pupil);
        }
        
        for (Lesson less : listLessons) {
            less.setPupilsG(listPupils);
            lessonService.save(less);
        }
    }

}
