package io.github.ordermanagement.service;

import io.github.ordermanagement.model.Order;
import io.github.ordermanagement.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id).orElse(null);
    }

    @Override
    public void cancelOrder(Long id) {
        Order order = orderRepository.findOrderById(id).orElse(null);
        if (order != null) {
            order.setStatus("Cancelled");
            orderRepository.addOrder(order);
        }
    }
}