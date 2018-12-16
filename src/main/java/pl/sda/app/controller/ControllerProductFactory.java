package pl.sda.app.controller;

import org.hibernate.Session;
import pl.sda.app.repository.mysql.MySqlRepositoryProduct;

public class ControllerProductFactory {
    public ControllerProduct create(Session session) {
        MySqlRepositoryProduct mySqlRepositoryProduct = new MySqlRepositoryProduct(session);
        return new ControllerProduct(session,mySqlRepositoryProduct);
    }
}
