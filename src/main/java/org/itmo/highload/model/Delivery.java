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
    private List<UserOrder> userOrders;

    public Delivery() {}

    public Delivery(UUID id, UserData userData, List<UserOrder> userOrders) {
        this.id = id;
        this.userData = userData;
        this.userOrders = userOrders;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
    public UserData getUserData() {
        return userData;
    }
}
