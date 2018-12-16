package pl.sda.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Warehouses")
public class Warehouse {
    @Id
    @GeneratedValue
    @Column(name = "warehouse_id")
    private int id;
    private String name;
    private String street;
    @Column(name = "building_number")
    private String buildingNumber;
    private String city;
    @Column(name = "postal_code")
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

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public void changeName(String name) {

        this.name = name;
    }
}
