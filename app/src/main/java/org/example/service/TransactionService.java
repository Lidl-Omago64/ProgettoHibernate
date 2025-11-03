package org.example.service;

import org.example.model.transaction.Transaction;
import org.example.repository.HibernateController;
import org.example.repository.HibernateControllerInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private HibernateControllerInterface<Transaction> transactionRepository;

    public TransactionService() {
        this.transactionRepository = new HibernateController<Transaction>(Transaction.class);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAll();
    }

    public Transaction addTransaction(Transaction transaction) {
        transactionRepository.add(transaction);
        return transaction;
    }
}
