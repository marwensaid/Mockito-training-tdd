package io.github.inventorymanagement.model;

import java.util.Date;

public class Transaction {
    private Long id;
    private Item item;
    private int quantity;
    private Date date;
    private String type; // 'IN' for adding stock, 'OUT' for removing stock

    // Constructors, getters, and setters
    public Transaction(Long id, Item item, int quantity, Date date, String type) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}