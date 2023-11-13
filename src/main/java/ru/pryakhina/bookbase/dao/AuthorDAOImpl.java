package ru.pryakhina.bookbase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pryakhina.bookbase.models.Author;

import javax.transaction.Transactional;
import java.util.List;

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
        return authors;
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.save(author);
    }
}
