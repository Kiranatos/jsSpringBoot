package net.kiranatos.services.unidir.mtm;

import net.kiranatos.model.unidir.mtm.Book;
import net.kiranatos.repositories.unidir.mtm.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
}
