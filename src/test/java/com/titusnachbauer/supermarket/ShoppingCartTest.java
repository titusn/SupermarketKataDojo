package com.titusnachbauer.supermarket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShoppingCartTest {
    private final ShoppingCart cart = new ShoppingCart();

    @Test
    void GivenNewShoppingCartWhenCountingItemsThenCountShouldBeZero() {
        assertEquals(0, cart.itemCount());
    }

    @Test
    void GivenShoppingCartWhenAddingOneItemThenCountShouldBeOne() {
        cart.addItem(new Item());
        assertEquals(1, cart.itemCount());
    }

    @Test
    void GivenShoppingCartContainingOneItemWhenRemovingOneItemThenCountShouldBeZero() {
        cart.addItem(new Item());
        cart.remove(new Item());
        assertEquals(0, cart.itemCount());
    }

    @Test
    void GivenEmptyShoppingCartWhenTryingToRemoveItemThenExceptionIsThrown() {
        assertThrows(Underflow.class, () -> cart.remove(new Item()));
    }
}
