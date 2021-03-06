package pl.sda.app.domain;

public class ProductFactory {

    public Product create(String name, String catalogNumber, float value, Currency currency) {
        Price price = new Price(value,currency);
        return new Product(name,catalogNumber,price);
    }
}
