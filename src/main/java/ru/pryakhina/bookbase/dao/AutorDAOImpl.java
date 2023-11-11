package ru.pryakhina.bookbase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pryakhina.bookbase.models.Autor;

import java.util.List;

//@Repository("autorRep")
@Repository
public class AutorDAOImpl implements AutorDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AutorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Autor> getAllAutors() {
        Session session = sessionFactory.getCurrentSession();
//        List<Autor> autors = session.createQuery("select a from Autor a", Autor.class)
//                .getResultList();
//        return autors;
        return null;
    }
}
