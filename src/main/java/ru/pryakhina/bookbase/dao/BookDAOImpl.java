package ru.pryakhina.bookbase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pryakhina.bookbase.models.Author;
import ru.pryakhina.bookbase.models.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getAllBooks() {

        Session session = sessionFactory.getCurrentSession();

        List<Book> books = session.createQuery("from Book", Book.class)
                .getResultList();

        return books;
    }
}
