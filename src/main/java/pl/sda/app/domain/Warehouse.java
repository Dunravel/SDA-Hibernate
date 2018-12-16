package pl.sda.app.domain;

import javax.swing.text.StringContent;

public class Warehouse {
    private int id;
    private String name;
    private String street;
    private String buildingNumber;
    private String city;
    private String postalCode;
    private String country;

    private Warehouse() {}

    public Warehouse(String name, String street, String buildingNumber, String city, String postalCode, String country) {
        this.name = name;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }


}
