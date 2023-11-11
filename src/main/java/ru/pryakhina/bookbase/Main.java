package ru.pryakhina.bookbase;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.pryakhina.bookbase.models.Autor;


public class Main {

    public SessionFactory sessionFactory;


    public Main() {

    }

    public static void main(String[] args) {




    }

    public void bg()
    {

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Autor autor = session.get(Autor.class,1);
            session.getTransaction().commit();
            System.out.println(autor);
        }
        finally {
            sessionFactory.close();
        }
    }
}
