package ru.pryakhina.bookbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pryakhina.bookbase.dao.AuthorDAO;
import ru.pryakhina.bookbase.dao.BookDAO;
import ru.pryakhina.bookbase.dto.AuthorDto;
import ru.pryakhina.bookbase.dto.BookDto;
import ru.pryakhina.bookbase.models.Author;
import ru.pryakhina.bookbase.models.Book;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public void delBook(Book book) {
        bookDAO.delBook(book);
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

    @Override
    @Transactional
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public BookDto getBookDto(int id) {
        Book book = bookDAO.getBook(id);

        BookDto bookDto = new BookDto();
        bookDto.setBookId(book.getBookId());
        bookDto.setBookName(book.getBookName());
        bookDto.setGenre(book.getGenre());
        bookDto.setAuthors(mapAuthorsWithoutBook(book.getAuthors()));
        return bookDto;
    }

    private List<AuthorDto> mapAuthorsWithoutBook(List<Author> authors) {
        if (authors == null || authors.isEmpty()) {
            return null;
        }

        List<AuthorDto> answer = new ArrayList<>();
        for (Author a: authors) {
            AuthorDto dto = new AuthorDto();
            dto.setAuthorId(a.getAuthorId());
            dto.setAuthorFullName(a.getAuthorFullName());
            if (a.getBooksList() != null && !a.getBooksList().isEmpty()) {
                dto.setBooksCount(a.getBooksList().size());
            }
            answer.add(dto);
        }
        return answer;
    }
}
