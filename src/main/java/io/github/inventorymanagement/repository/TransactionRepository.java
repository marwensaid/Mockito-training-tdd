package io.github.inventorymanagement.repository;


import io.github.inventorymanagement.model.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TransactionRepository {
    private Map<Long, Transaction> transactions = new HashMap<>();

    public void addTransaction(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);
    }

    public Optional<Transaction> findTransactionById(Long id) {
        return Optional.ofNullable(transactions.get(id));
    }

    public void removeTransactionById(Long id) {
        transactions.remove(id);
    }
}