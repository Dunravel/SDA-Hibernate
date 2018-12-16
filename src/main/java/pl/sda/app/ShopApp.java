package pl.sda.app;
import pl.sda.app.controller.ControllerProduct;
import pl.sda.app.controller.ControllerProductFactory;
import pl.sda.app.controller.ControllerWarehouse;
import pl.sda.app.domain.Product;
import pl.sda.app.domain.Warehouse;
import pl.sda.app.dto.WarehouseData;
import pl.sda.app.hibernate.*;

import org.hibernate.Session;
import pl.sda.app.repository.mysql.MySqlRepositoryWarehouse;

import java.util.List;

public class ShopApp
{

    public static void main(String[] args) {

        Session session = HibernateSessionRegistry
                .getSessionFactory()
                .openSession();

        ControllerProductFactory factory = new ControllerProductFactory();
        ControllerProduct controllerProduct = factory.create(session);

        // Jeżeli robimty tylko odczyt, to nie potrzebujemy Try Catch, jeżeli zmieniamy coś na bazie to trzeba zrobić.
        String catalogNumber = "910-000444";
        String name = "PC";
        float value = 10;
        String currency = "PLN";

        Integer productId = controllerProduct.create(name, catalogNumber, value,currency);
//
//        Product product = controllerProduct.find(productId);
//        System.out.println(product);
//
//        String description = "playstation";
//        controllerProduct.changeDescription(productId,description);
//
//        product = controllerProduct.find(productId);
//        System.out.println(product);

        //controllerProduct.deleteProduct(productId);

//        product = controllerProduct.find(productId);
//        System.out.println(product);

        List<Product> products = controllerProduct.findAll();
        products.forEach(System.out::println);



        MySqlRepositoryWarehouse mySqlRepositoryWarehouse = new MySqlRepositoryWarehouse(session);
        ControllerWarehouse controllerWarehouse = new ControllerWarehouse(session, mySqlRepositoryWarehouse);

//        WarehouseData warehouseData = new WarehouseData();
//        warehouseData.name = "Store no.7";
//        warehouseData.street = "Żabia";
//        warehouseData.buildingNumber = "148";
//        warehouseData.city = "Kraków";
//        warehouseData.postalCode = "30-830";
//        warehouseData.country = "Polska";
//        warehouseData.ownerName = "Marcin";
//        warehouseData.ownerSex = "Male";
//
//        Integer warehouseId = controllerWarehouse.create(warehouseData);
//        Warehouse warehouse = controllerWarehouse.find(warehouseId);
//        System.out.println(warehouse);
//
//        controllerWarehouse.updateName(warehouseId,"New Stock");
//          controllerWarehouse.updateName(2,"Stock 2");
//          controllerWarehouse.updateName(3,"Stock 3");
//
//        controllerWarehouse.delete(warehouseId);

        List<Warehouse> warehouses  = controllerWarehouse.findAll();
        warehouses.forEach(System.out::println);

        session.close();
        HibernateSessionRegistry.shutdown();
    }
}
