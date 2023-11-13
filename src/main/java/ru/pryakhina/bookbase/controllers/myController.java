package ru.pryakhina.bookbase.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pryakhina.bookbase.dao.AuthorDAO;
import ru.pryakhina.bookbase.models.Author;
import ru.pryakhina.bookbase.models.Book;
import ru.pryakhina.bookbase.models.Genre;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class myController {

    @Autowired
//    @Qualifier("autorRep")
    private AuthorDAO authorDAO;

    @GetMapping("/")
    public String showStartPage(HttpServletRequest request, Model model){
//        String bookId = request.getParameter("bookId");
//        bookId = bookId + 100;
//        model.addAttribute("bookId100", bookId);
        return "startpage";
    }

    @GetMapping("/books")
    public String getBooks(
            @RequestParam("bookId") int bookId,
            @RequestParam("bookName") String bookName,
            @RequestParam("genre") Genre genre,
            BindingResult bindingResult,
            Model model){
        if (bindingResult.hasErrors())
            return "booksaddnosql";
        else {
            Book selectBook = new Book(bookId, bookName, genre);
            model.addAttribute("book", selectBook);

            return "books";
        }
    }
    @GetMapping("/books/{id}")
    public String getBooksId(Model model){

        return "bookid";
    }
    @GetMapping("/authors")
    public String getAutors(Model model) {
        List<Author> autorList =  authorDAO.getAllAuthors();
        model.addAttribute("allAutors", autorList);
        return "authors";
    }

    @PostMapping("/bookAdd")
    public String bookAdd () {
        return "books";
    }

    @GetMapping("/booksaddnosql")
    public String bookAddNoSql(){
//new Main().bg();
        return "booksaddnosql";
    }
}