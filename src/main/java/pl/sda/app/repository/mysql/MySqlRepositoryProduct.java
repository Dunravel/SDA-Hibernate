package pl.sda.app.repository.mysql;

import org.hibernate.Session;
import pl.sda.app.domain.Product;

public class MySqlRepositoryProduct {

    private final Session session;

    public MySqlRepositoryProduct(Session session) {
        this.session = session;
    }

    public Integer save(Product product) {
        return (Integer) session.save(product);
    }

    public Product findByID(Integer productId) {
        return session.get(Product.class, productId);
    }

    public void update(Product product) {
         session.update(product);
    }
}
