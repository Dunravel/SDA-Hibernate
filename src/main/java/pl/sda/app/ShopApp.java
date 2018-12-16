package pl.sda.app;
import pl.sda.app.hibernate.*;

import org.hibernate.Session;

public class ShopApp
{

    public static void main(String[] args) {

        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        // Jeżeli robimty tylko odczyt, to nie potrzebujemy Try Catch, jeżeli zmieniamy coś na bazie to lepiej jest zrobić.
        try {
            session.getTransaction().begin();
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
        }
        session.close();
        HibernateSessionRegistry.shutdown();

    }
}
