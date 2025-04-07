package io.github.ordermanagement.service;


import io.github.ordermanagement.model.Order;

public interface OrderService {
    void createOrder(Order order);
    Order findOrderById(Long id);
    void cancelOrder(Long id);
}