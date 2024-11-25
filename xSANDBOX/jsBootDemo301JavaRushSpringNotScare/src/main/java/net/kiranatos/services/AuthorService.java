package net.kiranatos.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.kiranatos.entities.AuthorEntity;
import net.kiranatos.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void saveAll(List<AuthorEntity> books) {
        authorRepository.saveAll(books);
    }

    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }
}

