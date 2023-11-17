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
    public BookBaseServiceImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.saveAuthor(author);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public void delAuthor(Author author) {
        authorDAO.delAuthor(author);
    }

    @Override
    @Transactional
    public Author getAuthor(int authorId) {
        return authorDAO.getAuthor(authorId);
    }
}
