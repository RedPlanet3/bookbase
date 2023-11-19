package ru.pryakhina.bookbase.dao;

import ru.pryakhina.bookbase.models.Author;

import java.util.List;


public interface AuthorDAO {
    public List<Author> getAllAuthors();

    public void saveAuthor(Author author);

    public void delAuthor(Author author);

    public Author getAuthor(int authorId);

}