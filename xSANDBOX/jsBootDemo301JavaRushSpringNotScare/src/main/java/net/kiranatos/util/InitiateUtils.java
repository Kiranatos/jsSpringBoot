package net.kiranatos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.kiranatos.entities.AuthorEntity;
import net.kiranatos.entities.BookEntity;
import net.kiranatos.services.AuthorService;
import net.kiranatos.services.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        List<BookEntity> bookEntityList = new ArrayList<>(
                Arrays.asList(
                        new BookEntity()
                                .setNameBook("Горе от ума")
                                .setYearCreat(1824)
                                .setAuthorId(1),
                        new BookEntity()
                                .setNameBook("Война и мир")
                                .setYearCreat(1863)
                                .setAuthorId(2),
                        new BookEntity()
                                .setNameBook("Мцыри")
                                .setYearCreat(1838)
                                .setAuthorId(3),
                        new BookEntity()
                                .setNameBook("Евгений Онегин")
                                .setYearCreat(1833)
                                .setAuthorId(4)
                )
        );

        List<AuthorEntity> authorEntityList = new ArrayList<>(
                Arrays.asList(
                        new AuthorEntity()
                                .setFirstNameAuthor("Александр")
                                .setLastNameAuthor("Грибоедов"),
                        new AuthorEntity()
                                .setFirstNameAuthor("Лев")
                                .setLastNameAuthor("Толстой"),
                        new AuthorEntity()
                                .setFirstNameAuthor("Михаил")
                                .setLastNameAuthor("Лермонтов"),
                        new AuthorEntity()
                                .setFirstNameAuthor("Александр")
                                .setLastNameAuthor("Пушкин")
                ));

        bookService.saveAll(bookEntityList);
        authorService.saveAll(authorEntityList);

        System.out.println("\nТаблица книг");
        for(BookEntity book: bookService.findAll()){
            System.out.println(book);
        }

        System.out.println("\nТаблица авторов");
        for(AuthorEntity author : authorService.findAll()){
            System.out.println(author);
        }
        
        System.out.println("\nТаблица книг и их авторов, через строку");
//        for(String book: bookService.joinBookSting()){
//            System.out.println(book);
//        }

        System.out.println("\nТаблица книг и их авторов, нечитаемый объект");
//        for(Object book: bookService.joinBookObj()){
//            System.out.println(book);
//        }
    }
}

