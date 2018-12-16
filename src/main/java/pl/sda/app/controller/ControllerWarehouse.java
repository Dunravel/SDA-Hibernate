package pl.sda.app.controller;

import org.hibernate.Session;
import pl.sda.app.domain.Warehouse;
import pl.sda.app.repository.MySqlRepositoryWarehouse;

public class ControllerWarehouse {
    private final Session session;
    private final MySqlRepositoryWarehouse mySqlRepositoryWarehouse;

    public ControllerWarehouse(Session session, MySqlRepositoryWarehouse mySqlRepositoryWarehouse) {

        this.session = session;
        this.mySqlRepositoryWarehouse = mySqlRepositoryWarehouse;
    }

    public Warehouse create(String warehouse_name, String warehouse_street, String warehouse_building, String warehouse_city, String warehouse_postalcode, String warehouse_country) {
        return new Warehouse(warehouse_name,warehouse_street,warehouse_building,warehouse_city,warehouse_postalcode,warehouse_country);
    }
}
