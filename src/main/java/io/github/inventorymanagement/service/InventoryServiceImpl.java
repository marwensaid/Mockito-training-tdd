package io.github.inventorymanagement.service;


import io.github.inventorymanagement.model.Item;
import io.github.inventorymanagement.model.Stock;
import io.github.inventorymanagement.model.Transaction;
import io.github.inventorymanagement.repository.ItemRepository;
import io.github.inventorymanagement.repository.StockRepository;
import io.github.inventorymanagement.repository.TransactionRepository;

public class InventoryServiceImpl implements InventoryService {
    private ItemRepository itemRepository;
    private StockRepository stockRepository;
    private TransactionRepository transactionRepository;

    public InventoryServiceImpl(ItemRepository itemRepository, StockRepository stockRepository, TransactionRepository transactionRepository) {
        this.itemRepository = itemRepository;
        this.stockRepository = stockRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void addItem(Item item) {
        itemRepository.addItem(item);
        stockRepository.addStock(new Stock(item.getId(), item, 0));
    }

    @Override
    public void removeItem(Long itemId) {
        itemRepository.removeItemById(itemId);
        stockRepository.removeStockById(itemId);
    }

    @Override
    public void updateStock(Long itemId, int quantity) {
        Stock stock = stockRepository.findStockById(itemId).orElse(null);
        if (stock != null) {
            stock.setQuantity(quantity);
            stockRepository.addStock(stock);
        }
    }

    @Override
    public void processTransaction(Transaction transaction) {
        Stock stock = stockRepository.findStockById(transaction.getItem().getId()).orElse(null);
        if (stock != null) {
            int newQuantity = transaction.getType().equals("IN") ? stock.getQuantity() + transaction.getQuantity() : stock.getQuantity() - transaction.getQuantity();
            stock.setQuantity(newQuantity);
            stockRepository.addStock(stock);
            transactionRepository.addTransaction(transaction);
        }
    }

    @Override
    public Stock getStockByItemId(Long itemId) {
        return stockRepository.findStockById(itemId).orElse(null);
    }
}