package io.github.ordermanagement;

import io.github.ordermanagement.model.Customer;
import io.github.ordermanagement.model.Order;
import io.github.ordermanagement.model.Product;
import io.github.ordermanagement.repository.OrderRepository;
import io.github.ordermanagement.service.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateOrder() {
    }

    @Test
    void testFindOrderById() {
    }

    @Test
    void testCancelOrder() {
    }

    @Test
    void testFindOrderByIdNotFound() {
    }
}