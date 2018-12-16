package pl.sda.app;
import pl.sda.app.domain.Product;
import pl.sda.app.domain.Warehouse;
import pl.sda.app.hibernate.*;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;

public class ShopApp
{

    public static void main(String[] args) {

        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        // Jeżeli robimty tylko odczyt, to nie potrzebujemy Try Catch, jeżeli zmieniamy coś na bazie to lepiej jest zrobić.
        try {
            session.getTransaction().begin();

            String catalogNumber = "910-000444";
            String name = "PC";
            Product product = new Product(name, catalogNumber);
            Integer productId = (Integer) session.save(product);
            System.out.println(productId);

            Warehouse warehouse = new Warehouse("Store no.6","Żabia","148","Kraków","30-830","Polska");
            Integer warehouseId = (Integer) session.save(warehouse);
            System.out.println(warehouseId);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        HibernateSessionRegistry.shutdown();

    }
}
