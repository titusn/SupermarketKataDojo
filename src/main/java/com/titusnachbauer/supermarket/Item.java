package com.titusnachbauer.supermarket;

public class Item {
    private final Money price;
    private final String name;

    public Item(Money price) {
        this("", price);
    }

    public Item(double price) {
        this("", price);
    }

    public Item() {
        this(0.00);
    }

    public Item(String name, double price) {
        this(name, new Money(price));
    }

    public Item(String name, Money price) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price.getAmount().doubleValue();
    }

    public String getName() {
        return name;
    }

    public Money getAmount() {
        return price;
    }

    public String getItemLine() {
        //for the name of an item we need 26 columns and it will be displayed from left hand side
        return String.format("%-26s%s%6s", getName(), "EUR", getAmount().toString());
    }
}