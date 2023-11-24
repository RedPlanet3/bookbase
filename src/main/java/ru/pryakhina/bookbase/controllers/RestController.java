package ru.pryakhina.bookbase.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.pryakhina.bookbase.dto.BookDto;
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
    public BookDto getBook(@PathVariable int id) {

        BookDto book =  bookBaseService.getBookDto(id);
        if (book == null) {
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


    //получение json с данными работника с помощью @PathVariable
    @GetMapping("/books/{id}/wiki")
    public String getWikiBook(@PathVariable int id) {

        final RestTemplate restTemplate = new RestTemplate();
        String bookName = bookBaseService.getBook(id).getBookName();

        UriComponents url = UriComponentsBuilder.fromUriString("https://en.wikipedia.org/w/api.php")
                .queryParam("action", "query")
                .queryParam("list", "search")
                .queryParam("srsearch", bookName)
                .queryParam("format", "json")
                .build();

        String forObject = restTemplate.getForObject(url.toUri(), String.class);
        return forObject;
    }
}

//https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=Nelson_Mandela&utf8=&format=json
//https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=Nelson_Mandela&format=json