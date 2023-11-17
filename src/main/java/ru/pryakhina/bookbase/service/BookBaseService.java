package ru.pryakhina.bookbase.service;

import ru.pryakhina.bookbase.models.Author;
import ru.pryakhina.bookbase.models.Book;

import java.util.List;

public interface BookBaseService {
    public List<Author> getAllAuthors();
    public List<Book> getAllBooks();
    public void saveAuthor(Author author);
    public void saveBook(Book book);

    public void delAuthor(Author author);

    public Author getAuthor(int authorId);
}
