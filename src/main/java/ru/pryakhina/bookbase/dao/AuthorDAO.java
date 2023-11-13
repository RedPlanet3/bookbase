package ru.pryakhina.bookbase.dao;

import ru.pryakhina.bookbase.models.Author;

import java.util.List;


public interface AuthorDAO {
    public List<Author> getAllAuthors();
}