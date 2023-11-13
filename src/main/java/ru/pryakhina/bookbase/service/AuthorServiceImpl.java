package ru.pryakhina.bookbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pryakhina.bookbase.dao.AuthorDAO;
import ru.pryakhina.bookbase.models.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }
}
