package io.github.ordermanagement.repository;

import io.github.ordermanagement.model.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomerRepository {
    private Map<Long, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Optional<Customer> findCustomerById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    public void removeCustomerById(Long id) {
        customers.remove(id);
    }
}