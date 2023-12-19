package net.kiranatos.repositories.unidir.mtm;

import net.kiranatos.model.unidir.mtm.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
