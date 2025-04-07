package io.github.inventorymanagement.service;

import io.github.inventorymanagement.model.Item;
import io.github.inventorymanagement.model.Stock;
import io.github.inventorymanagement.model.Transaction;
import io.github.inventorymanagement.repository.ItemRepository;
import io.github.inventorymanagement.repository.StockRepository;
import io.github.inventorymanagement.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    private Item item;
    private Stock stock;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        item = new Item(1L, "Laptop", "High-end gaming laptop");
        stock = new Stock(1L, item, 10);
        transaction = new Transaction(1L, item, 5, new Date(), "IN");
    }

    @Test
    void testAddItem() {
        inventoryService.addItem(item);
        verify(itemRepository, times(1)).addItem(item);
        verify(stockRepository, times(1)).addStock(any(Stock.class));
    }

    @Test
    void testRemoveItem() {
        inventoryService.removeItem(1L);
        verify(itemRepository, times(1)).removeItemById(1L);
        verify(stockRepository, times(1)).removeStockById(1L);
    }

    @Test
    void testUpdateStock() {
        when(stockRepository.findStockById(1L)).thenReturn(Optional.of(stock));

        inventoryService.updateStock(1L, 20);

        assertEquals(20, stock.getQuantity());
        verify(stockRepository, times(1)).addStock(stock);
    }

    @Test
    void testProcessTransaction() {
        when(stockRepository.findStockById(1L)).thenReturn(Optional.of(stock));

        inventoryService.processTransaction(transaction);

        assertEquals(15, stock.getQuantity());
        verify(stockRepository, times(1)).addStock(stock);
        verify(transactionRepository, times(1)).addTransaction(transaction);
    }

    @Test
    void testGetStockByItemId() {
        when(stockRepository.findStockById(1L)).thenReturn(Optional.of(stock));

        Stock foundStock = inventoryService.getStockByItemId(1L);
        assertNotNull(foundStock);
        assertEquals(10, foundStock.getQuantity());
    }
}