package com.titusnachbauer.supermarket;

public class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Item() {
        this("", 0.00);
    }

    public double getPrice() {
        return price;
    }
}
