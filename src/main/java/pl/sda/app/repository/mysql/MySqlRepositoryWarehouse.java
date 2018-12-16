package pl.sda.app.repository.mysql;

import org.hibernate.Session;
import pl.sda.app.domain.Warehouse;

public class MySqlRepositoryWarehouse {
    private final Session session;

    public MySqlRepositoryWarehouse(Session session) {

        this.session = session;
    }

    public Integer save(Warehouse warehouse) {
        return (Integer) session.save(warehouse);
    }

    public Warehouse find(Integer warehouseId) {
        return session.find(Warehouse.class, warehouseId);
    }

    public void updateName(Warehouse warehouse) {
        session.update(warehouse);
    }

    public void delete(Warehouse warehouse) {
        session.delete(warehouse);
    }
}
