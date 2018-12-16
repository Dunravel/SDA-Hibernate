package pl.sda.app;
import pl.sda.app.controller.ControllerProduct;
import pl.sda.app.controller.ControllerProductFactory;
import pl.sda.app.controller.ControllerWarehouse;
import pl.sda.app.domain.Product;
import pl.sda.app.domain.Warehouse;
import pl.sda.app.hibernate.*;

import org.hibernate.Session;
import pl.sda.app.repository.MySqlRepositoryWarehouse;
import pl.sda.app.repository.mysql.MySqlRepositoryProduct;

public class ShopApp
{

    public static void main(String[] args) {

        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        ControllerProductFactory factory = new ControllerProductFactory();
        ControllerProduct controllerProduct = factory.create(session);

        // Jeżeli robimty tylko odczyt, to nie potrzebujemy Try Catch, jeżeli zmieniamy coś na bazie to lepiej jest zrobić.
        String catalogNumber = "910-000444";
        String name = "PC";

        Integer productId = controllerProduct.craete(name, catalogNumber);

        Product product = controllerProduct.find(productId);
        System.out.println(product);

        String description = "playstation";
        controllerProduct.changeDescription(productId,description);

        product = controllerProduct.find(productId);
        System.out.println(product);

        controllerProduct.deleteProduct(productId);

        product = controllerProduct.find(productId);
        System.out.println(product);


        String warehouse_name = "Store no.6";
        String warehouse_street = "Żabia";
        String warehouse_building = "148";
        String warehouse_city = "Kraków";
        String warehouse_postalcode = "30-830";
        String warehouse_country = "Polska";

        MySqlRepositoryWarehouse mySqlRepositoryWarehouse = new MySqlRepositoryWarehouse(session);
        ControllerWarehouse controllerWarehouse = new ControllerWarehouse(session, mySqlRepositoryWarehouse);

        Integer warehouseId = controllerWarehouse.create(warehouse_name,warehouse_street,warehouse_building,warehouse_city,warehouse_postalcode,warehouse_country);
        //Warehouse warehouse = controllerWarehouse.find(warehouseId);


        session.close();
        HibernateSessionRegistry.shutdown();

    }
}
