package org.itmo.highload.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="delivery")
public class Delivery {

    @Id
    @Column(name="id")
    private UUID id;

    @OneToOne
    @JoinColumn(name="user_data_id", referencedColumnName = "id")
    private UserData userData;

    @OneToMany(mappedBy = "delivery")
    private List<Order> orders;

    public Delivery() {}

    public Delivery(UUID id, UserData userData, List<Order> orders) {
        this.id = id;
        this.userData = userData;
        this.orders = orders;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
    public UserData getUserData() {
        return userData;
    }
}
