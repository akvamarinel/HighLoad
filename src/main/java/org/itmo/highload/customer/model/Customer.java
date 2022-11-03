package org.itmo.highload.customer.model;

import lombok.*;
import org.itmo.highload.userdata.model.UserData;
import org.itmo.highload.userorder.model.UserOrder;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "address", nullable = false)
    private String address;

//    @OneToMany(mappedBy = "customer")
//    private List<UserOrder> userOrders;

    @OneToOne
    @JoinColumn(name = "user_data_id", referencedColumnName = "id")
    private UserData userData;

}
