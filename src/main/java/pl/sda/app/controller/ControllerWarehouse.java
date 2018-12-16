package pl.sda.app.controller;

import org.hibernate.Session;
import pl.sda.app.domain.Product;
import pl.sda.app.domain.Warehouse;
import pl.sda.app.repository.mysql.MySqlRepositoryWarehouse;

import java.util.List;

public class ControllerWarehouse {
    private final Session session;
    private final MySqlRepositoryWarehouse mySqlRepositoryWarehouse;

    public ControllerWarehouse(Session session, MySqlRepositoryWarehouse mySqlRepositoryWarehouse) {

        this.session = session;
        this.mySqlRepositoryWarehouse = mySqlRepositoryWarehouse;
    }

    public Integer create(String warehouse_name, String warehouse_street, String warehouse_building, String warehouse_city, String warehouse_postalcode, String warehouse_country) {
        Warehouse warehouse = new Warehouse(warehouse_name,warehouse_street,warehouse_building,warehouse_city,warehouse_postalcode,warehouse_country);
        Integer id = null;
        try {
            session.getTransaction().begin();

            id =  mySqlRepositoryWarehouse.save(warehouse);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return id;
    }

    public Warehouse find(Integer warehouseId) {
        return mySqlRepositoryWarehouse.find(warehouseId);
    }


    public void updateName(Integer warehouseId, String name) {
        Warehouse warehouse = find(warehouseId);
        warehouse.changeName(name);
        try {
            session.getTransaction().begin();

            mySqlRepositoryWarehouse.updateName(warehouse);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void delete(Integer warehouseId) {
        Warehouse warehouse = find(warehouseId);
        try {
            session.getTransaction().begin();

            mySqlRepositoryWarehouse.delete(warehouse);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<Product> findAll() {
        return mySqlRepositoryWarehouse.findAll();
    }
}
