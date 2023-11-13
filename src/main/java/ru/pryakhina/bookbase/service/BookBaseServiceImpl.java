package ru.pryakhina.bookbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pryakhina.bookbase.dao.AuthorDAO;
import ru.pryakhina.bookbase.dao.BookDAO;
import ru.pryakhina.bookbase.models.Author;
import ru.pryakhina.bookbase.models.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookBaseServiceImpl implements BookBaseService {

    private AuthorDAO authorDAO;
    private BookDAO bookDAO;

    @Autowired
    public BookBaseServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.saveAuthor(author);
    }
}
