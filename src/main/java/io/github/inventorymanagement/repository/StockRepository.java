package io.github.inventorymanagement.repository;


import io.github.inventorymanagement.model.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StockRepository {
    private Map<Long, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getId(), stock);
    }

    public Optional<Stock> findStockById(Long id) {
        return Optional.ofNullable(stocks.get(id));
    }

    public void removeStockById(Long id) {
        stocks.remove(id);
    }
}