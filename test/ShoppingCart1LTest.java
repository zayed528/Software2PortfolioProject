

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.ShoppingCart;
import components.standard.ShoppingCart1L;

/**
 * JUnit test fixture for {@code ShoppingCart1L}'s kernel methods.
 *
 * @author Zayed Ali
 */
public class ShoppingCart1LTest {

    // Test constructor creates empty cart.
    @Test
    public void testConstructorEmpty() {
        ShoppingCart cart = new ShoppingCart1L();
        assertEquals(0, cart.size());
        assertEquals(0.0, cart.getTotalPrice(), 0.01);
    }

    // Test addItem with single item to empty cart.
    @Test
    public void testAddItemToEmpty() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertEquals(1, cart.size());
        assertTrue(cart.contains("Apple"));
        assertEquals(1.50, cart.getPrice("Apple"), 0.01);
        assertEquals(2, cart.getQuantity("Apple"));
    }

    // Test addItem with multiple different items.
    @Test
    public void testAddItemMultipleDifferent() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);
        cart.addItem("Orange", 2.00, 1);

        assertEquals(3, cart.size());
        assertTrue(cart.contains("Apple"));
        assertTrue(cart.contains("Banana"));
        assertTrue(cart.contains("Orange"));
    }

    // Test addItem with duplicate item name increases quantity.
    @Test
    public void testAddItemDuplicateIncreasesQuantity() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Apple", 1.50, 3);

        assertEquals(1, cart.size());
        assertEquals(5, cart.getQuantity("Apple"));
        assertEquals(7.50, cart.getTotalPrice(), 0.01);
    }

    // Test addItem with zero price (free item).
    @Test
    public void testAddItemZeroPrice() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Free Sample", 0.0, 1);

        assertEquals(1, cart.size());
        assertEquals(0.0, cart.getPrice("Free Sample"), 0.01);
        assertEquals(0.0, cart.getTotalPrice(), 0.01);
    }

    // Test addItem with large quantity.
    @Test
    public void testAddItemLargeQuantity() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Bulk Item", 0.50, 1000);

        assertEquals(1, cart.size());
        assertEquals(1000, cart.getQuantity("Bulk Item"));
        assertEquals(500.0, cart.getTotalPrice(), 0.01);
    }

    // ========== removeItem Tests ==========

    // Test removeItem removes single item from cart.
    @Test
    public void testRemoveItemSingle() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        cart.removeItem("Apple");

        assertEquals(0, cart.size());
        assertFalse(cart.contains("Apple"));
    }

    // Test removeItem from cart with multiple items.
    @Test
    public void testRemoveItemFromMultiple() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);
        cart.addItem("Orange", 2.00, 1);

        cart.removeItem("Banana");

        assertEquals(2, cart.size());
        assertFalse(cart.contains("Banana"));
        assertTrue(cart.contains("Apple"));
        assertTrue(cart.contains("Orange"));
    }

    // Test removeItem removes first item.
    @Test
    public void testRemoveItemFirst() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);

        cart.removeItem("Apple");

        assertEquals(1, cart.size());
        assertTrue(cart.contains("Banana"));
    }

    // Test removeItem removes last item.
    @Test
    public void testRemoveItemLast() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);

        cart.removeItem("Banana");

        assertEquals(1, cart.size());
        assertTrue(cart.contains("Apple"));
    }

    // Test getTotalPrice with empty cart returns zero.
    @Test
    public void testGetTotalPriceEmpty() {
        ShoppingCart cart = new ShoppingCart1L();
        assertEquals(0.0, cart.getTotalPrice(), 0.01);
    }

    // Test getTotalPrice with single item.
    @Test
    public void testGetTotalPriceSingleItem() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertEquals(3.00, cart.getTotalPrice(), 0.01);
    }

    // Test getTotalPrice with multiple items.
    @Test
    public void testGetTotalPriceMultipleItems() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2); // 3.00
        cart.addItem("Banana", 0.75, 4); // 3.00
        cart.addItem("Orange", 2.00, 1); // 2.00

        assertEquals(8.00, cart.getTotalPrice(), 0.01);
    }

    // Test getTotalPrice with fractional prices.
    @Test
    public void testGetTotalPriceFractional() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Item1", 1.99, 3); // 5.97
        cart.addItem("Item2", 0.33, 2); // 0.66

        assertEquals(6.63, cart.getTotalPrice(), 0.01);
    }

    // Test getTotalPrice after adding then removing item.
    @Test
    public void testGetTotalPriceAfterRemove() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2); // 3.00
        cart.addItem("Banana", 0.75, 4); // 3.00
        cart.removeItem("Banana");

        assertEquals(3.00, cart.getTotalPrice(), 0.01);
    }

    // Test size with empty cart returns zero.
    @Test
    public void testSizeEmpty() {
        ShoppingCart cart = new ShoppingCart1L();
        assertEquals(0, cart.size());
    }

    // Test size with one item.
    @Test
    public void testSizeOne() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertEquals(1, cart.size());
    }

    // Test size with multiple items.
    @Test
    public void testSizeMultiple() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);
        cart.addItem("Orange", 2.00, 1);

        assertEquals(3, cart.size());
    }

    // Test size after removing item.
    @Test
    public void testSizeAfterRemove() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);
        cart.removeItem("Apple");

        assertEquals(1, cart.size());
    }

    // Test size doesn't change when adding duplicate item.
    @Test
    public void testSizeWithDuplicate() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Apple", 1.50, 3);

        assertEquals(1, cart.size());
    }
    // Test contains returns false for empty cart.
    @Test
    public void testContainsEmpty() {
        ShoppingCart cart = new ShoppingCart1L();
        assertFalse(cart.contains("Apple"));
    }

    // Test contains returns true for existing item.
    @Test
    public void testContainsTrue() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertTrue(cart.contains("Apple"));
    }

    // Test contains returns false for non-existing item.
    @Test
    public void testContainsFalse() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertFalse(cart.contains("Banana"));
    }

    // Test contains returns false after item removed.
    @Test
    public void testContainsAfterRemove() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.removeItem("Apple");

        assertFalse(cart.contains("Apple"));
    }

    // Test contains with multiple items.
    @Test
    public void testContainsMultiple() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);

        assertTrue(cart.contains("Apple"));
        assertTrue(cart.contains("Banana"));
        assertFalse(cart.contains("Orange"));
    }
    // Test getPrice returns correct price for single item.
    @Test
    public void testGetPriceSingle() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertEquals(1.50, cart.getPrice("Apple"), 0.01);
    }

    // Test getPrice with zero price item.
    @Test
    public void testGetPriceZero() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Free Sample", 0.0, 5);

        assertEquals(0.0, cart.getPrice("Free Sample"), 0.01);
    }

    // Test getPrice with fractional price.
    @Test
    public void testGetPriceFractional() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Item", 3.99, 1);

        assertEquals(3.99, cart.getPrice("Item"), 0.01);
    }

    // Test getPrice for different items.
    @Test
    public void testGetPriceDifferentItems() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);

        assertEquals(1.50, cart.getPrice("Apple"), 0.01);
        assertEquals(0.75, cart.getPrice("Banana"), 0.01);
    }

    // Test getQuantity returns correct quantity.
    @Test
    public void testGetQuantitySingle() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 5);

        assertEquals(5, cart.getQuantity("Apple"));
    }

    // Test getQuantity with quantity of 1.
    @Test
    public void testGetQuantityOne() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 1);

        assertEquals(1, cart.getQuantity("Apple"));
    }

    // Test getQuantity after adding duplicate.
    @Test
    public void testGetQuantityAfterDuplicate() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Apple", 1.50, 3);

        assertEquals(5, cart.getQuantity("Apple"));
    }

    // Test getQuantity for different items.
    @Test
    public void testGetQuantityDifferentItems() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 7);

        assertEquals(2, cart.getQuantity("Apple"));
        assertEquals(7, cart.getQuantity("Banana"));
    }

    // Test getQuantity with large quantity.
    @Test
    public void testGetQuantityLarge() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Bulk", 0.10, 10000);

        assertEquals(10000, cart.getQuantity("Bulk"));
    }

    // Test clear on empty cart.
    @Test
    public void testClearEmpty() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.clear();

        assertEquals(0, cart.size());
        assertEquals(0.0, cart.getTotalPrice(), 0.01);
    }

    // Test clear removes all items.
    @Test
    public void testClearWithItems() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);

        cart.clear();

        assertEquals(0, cart.size());
        assertEquals(0.0, cart.getTotalPrice(), 0.01);
        assertFalse(cart.contains("Apple"));
        assertFalse(cart.contains("Banana"));
    }

    // Test cart usable after clear.
    @Test
    public void testClearThenAdd() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.clear();
        cart.addItem("Orange", 2.00, 1);

        assertEquals(1, cart.size());
        assertTrue(cart.contains("Orange"));
    }

    // Test newInstance creates empty cart.
    @Test
    public void testNewInstanceEmpty() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = cart1.newInstance();

        assertEquals(0, cart2.size());
        assertEquals(0.0, cart2.getTotalPrice(), 0.01);
    }

    // Test newInstance doesn't copy data from original.
    @Test
    public void testNewInstanceIndependent() {
        ShoppingCart cart1 = new ShoppingCart1L();
        cart1.addItem("Apple", 1.50, 2);

        ShoppingCart cart2 = cart1.newInstance();

        assertEquals(0, cart2.size());
        assertEquals(1, cart1.size()); // Original unchanged
    }

    // Test newInstance creates independent cart.
    @Test
    public void testNewInstanceModifiable() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = cart1.newInstance();

        cart2.addItem("Banana", 0.75, 3);

        assertEquals(1, cart2.size());
        assertEquals(0, cart1.size());
    }

    // Test transferFrom with empty source.
    @Test
    public void testTransferFromEmpty() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart1.transferFrom(cart2);

        assertEquals(0, cart1.size());
        assertEquals(0, cart2.size());
    }

    // Test transferFrom moves all data.
    @Test
    public void testTransferFromWithData() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart2.addItem("Apple", 1.50, 2);
        cart2.addItem("Banana", 0.75, 3);

        cart1.transferFrom(cart2);

        assertEquals(2, cart1.size());
        assertEquals(0, cart2.size()); // Source empty
        assertTrue(cart1.contains("Apple"));
        assertTrue(cart1.contains("Banana"));
    }

    // Test transferFrom clears source.
    @Test
    public void testTransferFromClearsSource() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart2.addItem("Apple", 1.50, 2);

        cart1.transferFrom(cart2);

        assertEquals(0, cart2.size());
        assertFalse(cart2.contains("Apple"));
    }

    // Test transferFrom overwrites destination.
    @Test
    public void testTransferFromOverwrites() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart1.addItem("Orange", 2.00, 1);
        cart2.addItem("Apple", 1.50, 2);

        cart1.transferFrom(cart2);

        assertEquals(1, cart1.size());
        assertTrue(cart1.contains("Apple"));
        assertFalse(cart1.contains("Orange"));
    }
}