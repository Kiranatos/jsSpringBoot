package net.kiranatos.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.kiranatos.entities.BookEntity;
import net.kiranatos.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void saveAll(List<BookEntity> books) {
        bookRepository.saveAll(books);
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }
    
//    public List<String> joinBookSting() {
//        return bookRepository.joinBookString();
//    }
//    
//    public List<Object[]> joinBookObj() {
//        return bookRepository.joinBookObj();
//    }

}
