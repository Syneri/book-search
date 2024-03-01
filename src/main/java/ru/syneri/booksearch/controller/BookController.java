package ru.syneri.booksearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.syneri.booksearch.model.Book;
import ru.syneri.booksearch.service.BookService;

import java.util.List;

/**
 * http://localhost:8080/h2-console/
 *
 * поиск книги
 * http://localhost:8080/title/1769793976d
 *
 * добавить книги в БД
 * http://localhost:8080/add-books
 */
@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/title/{request}")
    public String searchBook(Model model, @PathVariable String request) {
//        System.out.println("/title " + request);
        List<Book> books = bookService.searchBooksByName(request);
        model.addAttribute("bookData", books);
        model.addAttribute("searchRequest", request);
        return "search.html";
    }

    @GetMapping(value = "/add/{bookName}")
    public String addBook(@PathVariable String bookName) {
        bookService.createBook(bookName);
        return "books.html";
    }

    @GetMapping(value = "/add-books")
    public String addBooks(Model model) {
        bookService.createBooks();
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("bookData", allBooks);
        return "books.html";
    }

}
