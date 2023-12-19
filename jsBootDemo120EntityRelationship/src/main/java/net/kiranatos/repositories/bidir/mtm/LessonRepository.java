package net.kiranatos.repositories.bidir.mtm;

import net.kiranatos.model.bidir.mtm.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
