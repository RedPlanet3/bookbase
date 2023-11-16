package ru.pryakhina.bookbase.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/authors")
    public List<Author> getJSAutors(Model model) {

        List<Author> autorList =  bookBaseService.getAllAuthors();
        return autorList;
    }
}
