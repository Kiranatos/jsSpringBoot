package net.kiranatos.repositories.unidir.mtm;

import java.util.List;
import net.kiranatos.model.unidir.mtm.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
    List<Author> getByName (String author); // див. проект jsBootDemo20QueryMethods

}
