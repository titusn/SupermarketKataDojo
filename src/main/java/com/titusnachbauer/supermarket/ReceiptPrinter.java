package com.titusnachbauer.supermarket;

class ReceiptPrinter {
    public String printItem(Item item, int quantity) {
        // For the name of an item we need 26 columns and it will
        // be displayed from left hand side
        return String.format("%-26s%s%6s", item.getName(), "EUR", item.getAmount().toString());
    }
}