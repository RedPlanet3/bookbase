package ru.pryakhina.bookbase.dao;

import ru.pryakhina.bookbase.models.Book;

import java.util.List;


public interface BookDAO {
    public List<Book> getAllBooks();

    public void saveBook(Book book);
}