package org.example.model.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VariableRateTransaction {
    @Column(nullable = false)
    private double baseAmount;
    @Column(nullable = false)
    private double interestRate;
    private double totalAmount;

    public VariableRateTransaction(double baseAmount, double interestRate) {
        this.baseAmount = baseAmount;
        this.interestRate = interestRate;
        this.totalAmount = calculateFinalAmount();
    }

    private double calculateFinalAmount() {
        return baseAmount + (baseAmount * (interestRate / 100));
    }
}
