package org.itmo.highload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<UserOrder> userOrders;

    @OneToOne
    @JoinColumn(name = "user_data_id", referencedColumnName = "id")
    private UserData userData;

}
