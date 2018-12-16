package pl.sda.app.domain;

import pl.sda.app.dto.WarehouseData;

public class WarehouseFactory {

    public Warehouse create(WarehouseData warehouseData) {
        Owner owner = new Owner(warehouseData.ownerName,warehouseData.ownerSex);
        return new Warehouse(warehouseData.name,warehouseData.street,warehouseData.buildingNumber,warehouseData.city,warehouseData.postalCode,warehouseData.country,owner);
    }
}
