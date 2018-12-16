package pl.sda.app.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    private String name;
    @Column(name = "catalog_number")
    private String catalogNumber;

    private String description;
    private Timestamp updateDate;

    public Product(String name, String catalogNumber) {
        this.name = name;
        this.catalogNumber = catalogNumber;
        this.updateDate =   new Timestamp(System.currentTimeMillis());
    }

    private Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalogNumber='" + catalogNumber + '\'' +
                ", description='" + description + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
