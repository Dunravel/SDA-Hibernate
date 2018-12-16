package pl.sda.app.domain;

import javax.persistence.*;

@Entity
@Table
public class Owner {
    @Id
    @GeneratedValue
    @Column(name = "owner_id")
    private int id;
    private String name;
    private String sex;

    private Owner() {}

    public Owner(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
