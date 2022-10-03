package com.titusnachbauer.supermarket;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartWithItemTest {
    private final ShoppingCart cart = new ShoppingCart();
    private final Item catFood = new Item("Cat food", 1.00);
    private final Item bottle = new Item("Bunny Bottle", 4.00);

    ShoppingCartWithItemTest() {
        cart.addItem(catFood);
    }

    @Test
    void GivenShoppingCartContainingOneItemWhenCalculatingTotalThenTotalIsPriceOfItem() {
        assertEquals(1.00, cart.totalPrice());
    }

    @Test
    void GivenShoppingCartWithMoreItemsWhenCalculatingTotalThenTotalIsSumOfItemPrices() {
        cart.addItem(new Item("Dog food", 2.00));
        assertEquals(3.00, cart.totalPrice());
    }

    @Test
    void GivenShoppingCartWithMoreItemsWhenRemovingItemThenTotalIsSumOfRemainingItems() {
        cart.addItem(bottle);
        cart.remove(bottle);
        assertEquals(1.00, cart.totalPrice());
    }

    @Test
    void GivenShoppingCartWithTwoItemsWhenRemovingOneThenItemCountShouldBeOne() {
        cart.addItem(bottle);
        cart.remove(bottle);
        assertEquals(1, cart.itemCount());
    }

    @Test
    void GivenShoppingCartWithTwoItemsWhenListingItemsThenItShouldContainBoth() {
        cart.addItem(bottle);
        assertEquals(List.of(catFood, bottle), cart.getItems());
    }
}
