package io.github.inventorymanagement.repository;

import io.github.inventorymanagement.model.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemRepository {
    private Map<Long, Item> items = new HashMap<>();

    public void addItem(Item item) {
        items.put(item.getId(), item);
    }

    public Optional<Item> findItemById(Long id) {
        return Optional.ofNullable(items.get(id));
    }

    public void removeItemById(Long id) {
        items.remove(id);
    }
}