package net.kiranatos.services.unidir.mtm;

import java.util.List;
import net.kiranatos.model.unidir.mtm.Author;
import net.kiranatos.repositories.unidir.mtm.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author) {
        authorRepository.save(author);
    }
    
    public Author getByAuthorName(String author) {
        List<Author> autors = authorRepository.getByName(author);
       
        return autors.get(0);
    }
}
