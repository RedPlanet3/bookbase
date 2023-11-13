package ru.pryakhina.bookbase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pryakhina.bookbase.models.Author;

import javax.transaction.Transactional;
import java.util.List;

//@Repository("autorRep")
@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AuthorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Author> getAllAuthors() {

        Session session = sessionFactory.getCurrentSession();
//        Session session;
//
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }

//        session.beginTransaction();

        List<Author> authors = session.createQuery("from Author", Author.class)
                .getResultList();
//        session.getTransaction().commit();
        return authors;
//        return null;
    }
}
