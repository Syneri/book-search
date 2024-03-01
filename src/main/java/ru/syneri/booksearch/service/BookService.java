package ru.syneri.booksearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.syneri.booksearch.model.Book;
import ru.syneri.booksearch.repository.BookRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.syneri.booksearch.utils.RandomUtils.getRandomArray;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooksByName(String bookName) {
        return bookRepository.findAllByNameContains(bookName);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void createBook(String bookName) {
        Book book = new Book();
        book.setName(bookName);
        bookRepository.saveAll(Collections.singletonList(book));
    }

    public void createBooks() {
        int[] randomBookNames = getRandomArray(100_000);
        List<Book> books = new ArrayList<>();
        for (int randomBookName : randomBookNames) {
            books.add(Book.builder().name(String.valueOf(randomBookName)).build());
        }
        bookRepository.saveAll(books);
    }
}
