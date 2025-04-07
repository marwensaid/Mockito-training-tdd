package io.github.ordermanagement;



import io.github.ordermanagement.model.Customer;
import io.github.ordermanagement.model.Order;
import io.github.ordermanagement.model.Product;
import io.github.ordermanagement.repository.CustomerRepository;
import io.github.ordermanagement.repository.OrderRepository;
import io.github.ordermanagement.repository.ProductRepository;
import io.github.ordermanagement.service.OrderService;
import io.github.ordermanagement.service.OrderServiceImpl;

import java.util.Arrays;

public class OrderManagementApplication {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderServiceImpl(orderRepository);

        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");
        Product product1 = new Product(1L, "Laptop", 999.99);
        Product product2 = new Product(2L, "Mouse", 19.99);

        Order order = new Order(1L, customer, Arrays.asList(product1, product2), "New");

        orderService.createOrder(order);

        System.out.println("Order Created: " + orderService.findOrderById(1L));
    }
}