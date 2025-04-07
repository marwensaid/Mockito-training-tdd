package io.github.inventorymanagement;

import io.github.inventorymanagement.model.Item;
import io.github.inventorymanagement.model.Stock;
import io.github.inventorymanagement.model.Transaction;
import io.github.inventorymanagement.repository.ItemRepository;
import io.github.inventorymanagement.repository.StockRepository;
import io.github.inventorymanagement.repository.TransactionRepository;
import io.github.inventorymanagement.service.InventoryService;
import io.github.inventorymanagement.service.InventoryServiceImpl;

import java.util.Date;

public class InventoryManagementApplication {
    public static void main(String[] args) {
        ItemRepository itemRepository = new ItemRepository();
        StockRepository stockRepository = new StockRepository();
        TransactionRepository transactionRepository = new TransactionRepository();
        InventoryService inventoryService = new InventoryServiceImpl(itemRepository, stockRepository, transactionRepository);

        Item item = new Item(1L, "Laptop", "High-end gaming laptop");
        inventoryService.addItem(item);

        Transaction transaction = new Transaction(1L, item, 10, new Date(), "IN");
        inventoryService.processTransaction(transaction);

        Stock stock = inventoryService.getStockByItemId(1L);
        System.out.println("Stock for item: " + stock.getQuantity());
    }
}