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

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");
        Product product1 = new Product(1L, "Laptop", 999.99);
        Product product2 = new Product(2L, "Mouse", 19.99);

        order = new Order(1L, customer, Arrays.asList(product1, product2), "New");
    }

    @Test
    void testCreateOrder() {
        orderService.createOrder(order);
        verify(orderRepository, times(1)).addOrder(order);
    }

    @Test
    void testFindOrderById() {
        when(orderRepository.findOrderById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.findOrderById(1L);
        assertNotNull(foundOrder);
        assertEquals("New", foundOrder.getStatus());
    }

    @Test
    void testCancelOrder() {
        when(orderRepository.findOrderById(1L)).thenReturn(Optional.of(order));

        orderService.cancelOrder(1L);

        assertEquals("Cancelled", order.getStatus());
        verify(orderRepository, times(1)).addOrder(order);
    }

    @Test
    void testFindOrderByIdNotFound() {
        when(orderRepository.findOrderById(1L)).thenReturn(Optional.empty());

        Order foundOrder = orderService.findOrderById(1L);
        assertNull(foundOrder);
    }
}