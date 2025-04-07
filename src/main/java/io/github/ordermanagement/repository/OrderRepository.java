package io.github.ordermanagement.repository;



import io.github.ordermanagement.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderRepository {
    private Map<Long, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Optional<Order> findOrderById(Long id) {
        return Optional.ofNullable(orders.get(id));
    }

    public void removeOrderById(Long id) {
        orders.remove(id);
    }
}