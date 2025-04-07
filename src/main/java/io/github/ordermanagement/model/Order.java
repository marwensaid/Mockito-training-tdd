package io.github.ordermanagement.model;

import java.util.List;

public class Order {
    private Long id;
    private Customer customer;
    private List<Product> products;
    private String status;

    // Constructors, getters, and setters
    public Order(Long id, Customer customer, List<Product> products, String status) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}