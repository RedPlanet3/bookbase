package ru.pryakhina.bookbase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pryakhina.bookbase.models.Author;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AuthorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Author> getAllAuthors() {

        Session session = sessionFactory.getCurrentSession();

        List<Author> authors = session.createQuery("from Author", Author.class)
                .getResultList();
        Collections.sort(authors);
        return authors;
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public void delAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(author);
    }

    @Override
    public Author getAuthor(int authorId) {
        Session session = sessionFactory.getCurrentSession();
        Author author = session.get(Author.class, authorId);
        return author;
    }
}
