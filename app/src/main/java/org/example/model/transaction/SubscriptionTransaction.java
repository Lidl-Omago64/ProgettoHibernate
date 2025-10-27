package org.example.model.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class SubscriptionTransaction extends Transaction {
    @Column(nullable = false)
    private String subscriptionName;
    @Column(nullable = false)
    private double montlyFee;
    @Column(nullable = false)
    private Date startDate;
    private Date endDate;

    public SubscriptionTransaction() {}
}
