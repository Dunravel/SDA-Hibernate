package pl.sda.app;
import pl.sda.app.domain.Product;
import pl.sda.app.domain.Warehouse;
import pl.sda.app.hibernate.*;

import org.hibernate.Session;
import pl.sda.app.repository.mysql.MySqlRepositoryProduct;

import javax.persistence.criteria.CriteriaBuilder;

public class ShopApp
{

    public static void main(String[] args) {

        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        // Jeżeli robimty tylko odczyt, to nie potrzebujemy Try Catch, jeżeli zmieniamy coś na bazie to lepiej jest zrobić.
        String catalogNumber = "910-000444";
        String name = "PC";
        Product product = new Product(name, catalogNumber);

        try {
            session.getTransaction().begin();

            Integer productId  = new MySqlRepositoryProduct(session)
                    .save(product);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        Warehouse warehouse = new Warehouse("Store no.6","Żabia","148","Kraków","30-830","Polska");
        try {
            session.getTransaction().begin();

            Integer warehouseId = (Integer) session.save(warehouse);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        HibernateSessionRegistry.shutdown();

    }
}
