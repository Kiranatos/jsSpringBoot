package net.kiranatos.util.unidir.mtm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.kiranatos.model.unidir.mtm.Author;
import net.kiranatos.model.unidir.mtm.Book;
import net.kiranatos.services.unidir.mtm.AuthorService;
import net.kiranatos.services.unidir.mtm.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtilsBookAuthor implements CommandLineRunner {

    private final AuthorService authorService;
    private final BookService bookService;
    
    private final int nBooks = 5;
    Random random = new Random();

    public InitiateUtilsBookAuthor(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Unidirectional association | @ManyToMany | Book and Author entities >>> ");

        String[] arrAuthors = {"Jane Austen", "Charles Dickens", "William Shakespeare", "Agatha Christie",
            "F. Scott Fitzgerald", "George Orwell", "J.K. Rowling", "Leo Tolstoy",
            "Mark Twain", "J.R.R. Tolkien", "Harper Lee", "Gabriel Garcia Marquez"};
        for (String arrAuthor : arrAuthors) {
            Author author = new Author();
            author.setName(arrAuthor);
            authorService.save(author);
        }

        String[] arrTitles = {"The Great Gatsby", "To Kill a Mockingbird", "1984", "Pride and Prejudice",
            "Harry Potter and the Sorcerer's Stone", "The Catcher in the Rye", "War and Peace", "The Hobbit",
            "The Lord of the Rings", "Crime and Punishment", "The Odyssey", "One Hundred Years of Solitude"};
        List<String> titleList = new ArrayList<>(Arrays.asList(arrTitles)); /* назви книг переганяються в List, оскільки 
                                    в процесі роботи, щоб не було повторів вони будуть видалятися в {1} */

        for (int i = 0; i < nBooks; i++) {
            String randomTitle = titleList.remove(  // {1}
                    random.nextInt(titleList.size())
            );
            Book book = new Book();
            book.setName(randomTitle);

            int nAutors = random.nextInt(arrTitles.length / 3) + 1; // +1 на випадок, якщо рандом видасть 0. Бо в такому випадку книга взагалі не додасться
            Set<Author> setA = new HashSet<>();
            List<String> autorsList = new ArrayList<>(Arrays.asList(arrAuthors)); /* назви авторів переганяються в List, оскільки 
            в процесі роботи, щоб не було повторів вони будуть видалятися в {2}. Тут це особливо було критично, оскільки повтори не додавались в Set і
            авторів в Set-і було меньше ніж очікував Хібернейт і тому все падало. */
            for (int j = 0; j < nAutors; j++) {

                String randomAuthor = autorsList.remove(  // {2}
                        random.nextInt(autorsList.size())
                );

                Author author = authorService.getByAuthorName(randomAuthor);

                setA.add(author);

            }
            book.setAuthors(setA);

            bookService.save(book);
        }
    }
}
