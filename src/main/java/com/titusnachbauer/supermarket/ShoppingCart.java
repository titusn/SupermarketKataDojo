package com.titusnachbauer.supermarket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int count = 0;
    private double total = 0.00;
    private final List<Item> items = new ArrayList<>();

    public int itemCount() {
        return count;
    }

    public void addItem(Item item) {
        count++;
        total += item.getPrice();
        items.add(item);
    }

    public double totalPrice() {
        return total;
    }

    public void remove(Item item) {
        if (count <= 0) {
            throw new Underflow();
        }
        count--;
        total -= item.getPrice();
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
