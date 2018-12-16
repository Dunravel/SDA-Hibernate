package pl.sda.app.domain;

public class WarehouseFactory {

    public Warehouse create(String warehouse_name, String warehouse_street, String warehouse_building, String warehouse_city, String warehouse_postalcode, String warehouse_country, String ownerName, String ownerSex) {
        Owner owner = new Owner(ownerName,ownerSex);
        Warehouse warehouse = new Warehouse(warehouse_name,warehouse_street,warehouse_building,warehouse_city,warehouse_postalcode,warehouse_country,owner);
        return warehouse;
    }
}
