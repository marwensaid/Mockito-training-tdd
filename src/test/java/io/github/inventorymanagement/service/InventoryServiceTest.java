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


    private Transaction transaction;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testAddItem() {

    }

    @Test
    void testRemoveItem() {

    }

    @Test
    void testUpdateStock() {

    }

    @Test
    void testProcessTransaction() {

    }

    @Test
    void testGetStockByItemId() {

    }
}