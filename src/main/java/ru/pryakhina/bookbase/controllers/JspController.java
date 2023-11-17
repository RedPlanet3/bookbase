package ru.pryakhina.bookbase.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pryakhina.bookbase.models.Author;
import ru.pryakhina.bookbase.models.Book;
import ru.pryakhina.bookbase.service.BookBaseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RestController
public class JspController {

    @Autowired
//    @Qualifier("autorRep")
    private BookBaseService bookBaseService;

    @GetMapping("/")
    public String showStartPage(HttpServletRequest request, Model model){
//        String bookId = request.getParameter("bookId");
//        bookId = bookId + 100;
//        model.addAttribute("bookId100", bookId);
        return "startpage";
    }

    @GetMapping("/books")
    public String getBooks(
//            @RequestParam("bookId") int bookId,
//            @RequestParam("bookName") String bookName,
//            @RequestParam("genre") Genre genre,
//            BindingResult bindingResult,
            Model model){

        List<Book> bookList =  bookBaseService.getAllBooks();
        model.addAttribute("allBooks", bookList);
       return "books";
    }

    @GetMapping("/books/{id}")
    public String getBooksId(Model model){

        return "bookid";
    }
    @GetMapping("/authors")
    public String getAuthors(Model model) {
        List<Author> authorList =  bookBaseService.getAllAuthors();
        model.addAttribute("allAutors", authorList);
        return "authors";
    }

    @PostMapping("/bookadd")
    public String bookAdd () {
        return "books";
    }

    @GetMapping("/authoradd")
    public String authoradd(Model model) {
        Author newauthor = new Author();
        model.addAttribute("newauthor", newauthor);
        return "authoradd";
    }

    @PostMapping("/saveauthor")
    public String saveAuthor (@ModelAttribute("newauthor") Author author, Model model) {
        model.addAttribute("author", author);
        bookBaseService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/updateAuthor")
    public String updateAuthor (
            @ModelAttribute("newauthor") Author author,
            Model model
    ) {
        Author upAuthor = bookBaseService.getAuthor(author.getAuthorId());
        model.addAttribute("newauthor", upAuthor);
        return "authoradd";
    }

    @GetMapping("/deleteAuthor")
    public String deleteAuthor (@ModelAttribute("newauthor") Author delAuthor) {
        Author deleteAuthor = bookBaseService.getAuthor(delAuthor.getAuthorId());
        bookBaseService.delAuthor(deleteAuthor);
        return "redirect:/authors";
    }

}