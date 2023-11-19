package ru.pryakhina.bookbase.controllers;


import org.springframework.web.bind.annotation.*;
import ru.pryakhina.bookbase.exception_handing.NoSuchAuthorException;
import ru.pryakhina.bookbase.models.Author;
import ru.pryakhina.bookbase.models.Book;
import ru.pryakhina.bookbase.service.BookBaseService;

import java.util.List;

@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    BookBaseService bookBaseService;

    public RestController(BookBaseService bookBaseService) {
        this.bookBaseService = bookBaseService;
    }

    //получение json с данными всех работников
    @GetMapping("/authors")
    public List<Author> getAuthors() {

        List<Author> autorList =  bookBaseService.getAllAuthors();
        return autorList;
    }
    @GetMapping("/books")
    public List<Book> getBooks() {

        List<Book> bookList =  bookBaseService.getAllBooks();
        return bookList;
    }

    //получение id работника из адресной строки с помощью @PathVariable
    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int id) {

        Author author =  bookBaseService.getAuthor(id);
        if (author == null)
        {
            throw new NoSuchAuthorException("There is no author with ID = " + id + " in Database");
        }
        return author;
    }

    //получение json с данными работника с помощью @PathVariable
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id) {

        Book book =  bookBaseService.getBook(id);
        if (book == null)
        {
            throw new NoSuchAuthorException("There is no author with ID = " + id + " in Database");
        }
        return book;
    }
    @PostMapping("/books")
    public int addBook(@RequestBody Book book) {
        bookBaseService.saveBook(book);
        return book.getBookId();
    }
    @PutMapping("/books")
    public int updateBook(@RequestBody Book book) {
        bookBaseService.saveBook(book);
        return book.getBookId();
    }
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id) {
        Book delBook = bookBaseService.getBook(id);
        bookBaseService.delBook(delBook);
        return "The book id = " + id + " deleted!";
    }
}
