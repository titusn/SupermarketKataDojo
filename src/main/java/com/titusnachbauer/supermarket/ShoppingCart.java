package com.titusnachbauer.supermarket;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private int count = 0;
    private double totalPrice = 0;
    private List<Item> items = new ArrayList<>();

    public int itemCount() {
        return count;
    }

    public void add(Item item) {
        count += 1;
        totalPrice += item.getPrice();
        items.add(item);
    }

    public void remove(Item item) {
        if (isEmpty()) {
            throw new Underflow();
        }
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public double totalPrice() {
        return totalPrice;
    }

    public String generateReceipt() {
        String receipt = this.toString();
        return receipt + "TOTAL " + new Money(this.totalPrice).toString();
    }

    public String generateReceiptLine() {
        ReceiptPrinter printer = new ReceiptPrinter();
        return printer.printItem(items.get(0), 0);
    }

    class Underflow extends RuntimeException {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Item item : items) {
            sb.append(item.getName()).append(" ").append(item.getAmount().toString()).append("\n");
        }
        return sb.toString();
    }
}