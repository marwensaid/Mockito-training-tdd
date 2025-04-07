package io.github.inventorymanagement.service;

import io.github.inventorymanagement.model.Item;
import io.github.inventorymanagement.model.Stock;
import io.github.inventorymanagement.model.Transaction;

public interface InventoryService {
    void addItem(Item item);
    void removeItem(Long itemId);
    void updateStock(Long itemId, int quantity);
    void processTransaction(Transaction transaction);
    Stock getStockByItemId(Long itemId);
}