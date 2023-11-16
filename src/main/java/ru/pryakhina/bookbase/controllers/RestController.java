package ru.pryakhina.bookbase.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pryakhina.bookbase.exception_handing.BookBaseIncorrectData;
import ru.pryakhina.bookbase.exception_handing.NoSuchAuthorException;
import ru.pryakhina.bookbase.models.Author;
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

    //получение json с данными работника с помощью @PathVariable
    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int id) {

        Author author =  bookBaseService.getAuthor(id);
        if (author == null)
        {
            throw new NoSuchAuthorException("There is no author with ID = " + id + " in Database");
        }
        return author;
    }

    @ExceptionHandler
    public ResponseEntity<BookBaseIncorrectData> handleException(
            NoSuchAuthorException exception
    ){
        BookBaseIncorrectData data = new BookBaseIncorrectData(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
