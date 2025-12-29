package ro.ase.subscriptionshub.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String name;

    private String description;

    private String videoQuality;

    private int maxUsers;

    private boolean offline;

}
