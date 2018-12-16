package pl.sda.app.domain;

import javax.persistence.*;

@Entity
@Table
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "price_id")
    private int id;
    private float value;
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Price() {}
    Price(float value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}

