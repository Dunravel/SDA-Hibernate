package pl.sda.app.controller;

import org.hibernate.Session;
import pl.sda.app.domain.Price;
import pl.sda.app.domain.Product;
import pl.sda.app.domain.ProductFactory;
import pl.sda.app.repository.mysql.MySqlRepositoryProduct;

import java.util.List;

public class ControllerProduct {
    private final Session session;
    private final MySqlRepositoryProduct mySqlRepositoryProduct;

    public ControllerProduct(Session session, MySqlRepositoryProduct mySqlRepositoryProduct) {
        this.session = session;
        this.mySqlRepositoryProduct = mySqlRepositoryProduct;
    }


    public int create(String name, String catalogNumber, float value, String currency) {
        Product product = new ProductFactory().create(name,catalogNumber,value,currency);
        Integer id = null;
        try {
            session.getTransaction().begin();

            id  = mySqlRepositoryProduct.save(product);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return id;
    }

    public Product find(Integer productId) {
        return mySqlRepositoryProduct.findByID(productId);
    }

    public void changeDescription(Integer productId, String description) {
        Product product = find(productId);
        product.changeDescription(description);
        try {
            session.getTransaction().begin();

            mySqlRepositoryProduct.update(product);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public void deleteProduct(Integer productId) {
        Product product = find(productId);
        try {
            session.getTransaction().begin();

            mySqlRepositoryProduct.delete(product);

            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<Product> findAll() {
        return mySqlRepositoryProduct.findAll();
    }
}
