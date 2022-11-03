package org.itmo.highload.delivery.model;

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
@Table(name = "delivery")
public class Delivery {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_data_id", referencedColumnName = "id")
    private UserData userData;
}

