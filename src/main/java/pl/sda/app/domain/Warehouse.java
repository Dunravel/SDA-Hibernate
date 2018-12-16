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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    private Warehouse() {}

    Warehouse(String name, String street, String buildingNumber, String city, String postalCode, String country, Owner owner) {
        this.name = name;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.owner = owner;
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
                ", owner='" + owner + '\'' +
                '}';
    }

    public void changeName(String name) {

        this.name = name;
    }
}
