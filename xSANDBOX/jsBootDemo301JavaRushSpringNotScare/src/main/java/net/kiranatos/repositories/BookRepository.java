package net.kiranatos.repositories;

import java.util.List;
import net.kiranatos.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    
//        @Query("select b.nameBook, a.firstNameAuthor, a.lastNameAuthor, b.yearCreat from  AuthorEntity a left join BookEntity b on a.id = b.authorId")
//        List<String> joinBookString();
//        
//        @Query("select b.nameBook, a.firstNameAuthor, a.lastNameAuthor, b.yearCreat from  AuthorEntity a left join BookEntity b on a.id = p.authorId")
//        List<Object[]> joinBookObj ();

}
