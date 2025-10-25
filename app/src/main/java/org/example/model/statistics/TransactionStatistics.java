package org.example.model.statistics;

import org.example.model.transaction.Transaction;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionStatistics extends ExtendedStatistics{
    private final List<Transaction> transactions;

    public TransactionStatistics(LocalDate startDate, LocalDate endDate, List<Transaction> transaction) {
        super(startDate, endDate);
        this.transactions = transaction;
    }

    public List<Transaction> getTransactionsInPeriod() {
        if (transactions == null || getDateStart() == null || getDateEnd() == null) {
            return List.of();
        }

        return transactions.stream()
                .filter(t -> {
                    LocalDate d = t.getDate();
                    return d != null &&
                            !d.isBefore(getDateStart()) &&  // d >= start
                            !d.isAfter(getDateEnd());       // d <= end
                })
                .collect(Collectors.toList());
    }

    /**
     * Calcola la somma totale delle transazioni nel periodo
     */
    public double getTotalAmount() {
        return getTransactionsInPeriod().stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    /**
     * Calcola la media degli importi nel periodo
     */
    public double getAverageAmount() {
        List<Transaction> filtered = getTransactionsInPeriod();
        return filtered.isEmpty()
                ? 0.0
                : filtered.stream()
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0.0);
    }
}
