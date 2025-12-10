

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.ShoppingCart;
import components.standard.ShoppingCart1L;

/**
 * JUnit test fixture for {@code ShoppingCart}'s secondary methods.
 *
 * @author Zayed Ali
 */
public class ShoppingCartTest {

    // Test isEmpty with empty cart returns true
    @Test
    public void testIsEmptyTrue() {
        ShoppingCart cart = new ShoppingCart1L();
        assertTrue(cart.isEmpty());
    }

    // Test isEmpty with one item returns false
    @Test
    public void testIsEmptyFalseOneItem() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertFalse(cart.isEmpty());
    }

    // Test isEmpty with multiple items returns false
    @Test
    public void testIsEmptyFalseMultipleItems() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);

        assertFalse(cart.isEmpty());
    }

    // Test isEmpty after adding then removing all items
    @Test
    public void testIsEmptyAfterRemoveAll() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.removeItem("Apple");

        assertTrue(cart.isEmpty());
    }

    // Test isEmpty after clear
    @Test
    public void testIsEmptyAfterClear() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.clear();

        assertTrue(cart.isEmpty());
    }

    // Test updateQuantity increases quantity
    @Test
    public void testUpdateQuantityIncrease() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        cart.updateQuantity("Apple", 5);

        assertEquals(5, cart.getQuantity("Apple"));
        assertEquals(7.50, cart.getTotalPrice(), 0.01);
    }

    // Test updateQuantity decreases quantity
    @Test
    public void testUpdateQuantityDecrease() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 5);

        cart.updateQuantity("Apple", 2);

        assertEquals(2, cart.getQuantity("Apple"));
        assertEquals(3.00, cart.getTotalPrice(), 0.01);
    }

    // Test updateQuantity to 1
    @Test
    public void testUpdateQuantityToOne() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 10);

        cart.updateQuantity("Apple", 1);

        assertEquals(1, cart.getQuantity("Apple"));
        assertEquals(1.50, cart.getTotalPrice(), 0.01);
    }

    // Test updateQuantity doesn't affect other items
    @Test
    public void testUpdateQuantityOthersUnaffected() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 3);

        cart.updateQuantity("Apple", 5);

        assertEquals(5, cart.getQuantity("Apple"));
        assertEquals(3, cart.getQuantity("Banana"));
    }

    // Test updateQuantity with large quantity
    @Test
    public void testUpdateQuantityLarge() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Bulk", 0.50, 100);

        cart.updateQuantity("Bulk", 5000);

        assertEquals(5000, cart.getQuantity("Bulk"));
        assertEquals(2500.0, cart.getTotalPrice(), 0.01);
    }

    // Test getDiscountedTotal with 0% discount
    @Test
    public void testGetDiscountedTotalZeroPercent() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertEquals(3.00, cart.getDiscountedTotal(0.0), 0.01);
    }

    // Test getDiscountedTotal with 10% discount
    @Test
    public void testGetDiscountedTotalTenPercent() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 10.00, 1);

        assertEquals(9.00, cart.getDiscountedTotal(10.0), 0.01);
    }

    // Test getDiscountedTotal with 50% discount
    @Test
    public void testGetDiscountedTotalFiftyPercent() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 4);

        assertEquals(3.00, cart.getDiscountedTotal(50.0), 0.01);
    }

    // Test getDiscountedTotal with 100% discount (free)
    @Test
    public void testGetDiscountedTotalHundredPercent() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertEquals(0.00, cart.getDiscountedTotal(100.0), 0.01);
    }

    // Test getDiscountedTotal with empty cart
    @Test
    public void testGetDiscountedTotalEmpty() {
        ShoppingCart cart = new ShoppingCart1L();

        assertEquals(0.00, cart.getDiscountedTotal(25.0), 0.01);
    }

    // Test getDiscountedTotal with fractional discount
    @Test
    public void testGetDiscountedTotalFractional() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Item", 100.00, 1);

        assertEquals(67.50, cart.getDiscountedTotal(32.5), 0.01);
    }

    // Test toString with empty cart
    @Test
    public void testToStringEmpty() {
        ShoppingCart cart = new ShoppingCart1L();
        String result = cart.toString();

        assertTrue(result.contains("ShoppingCart"));
    }

    // Test toString with one item
    @Test
    public void testToStringOneItem() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        String result = cart.toString();

        assertTrue(result.contains("Apple"));
    }

    // Test toString with multiple items
    @Test
    public void testToStringMultipleItems() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);
        cart.addItem("Banana", 0.75, 4);

        String result = cart.toString();

        assertTrue(result.contains("Apple"));
        assertTrue(result.contains("Banana"));
    }

    // Test equals with two empty carts
    @Test
    public void testEqualsBothEmpty() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        assertTrue(cart1.equals(cart2));
    }

    // Test equals with same items
    @Test
    public void testEqualsSameItems() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart1.addItem("Apple", 1.50, 2);
        cart2.addItem("Apple", 1.50, 2);

        assertTrue(cart1.equals(cart2));
    }

    // Test equals with different items
    @Test
    public void testEqualsDifferentItems() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart1.addItem("Apple", 1.50, 2);
        cart2.addItem("Banana", 0.75, 3);

        assertFalse(cart1.equals(cart2));
    }

    // Test equals with different quantities
    @Test
    public void testEqualsDifferentQuantities() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart1.addItem("Apple", 1.50, 2);
        cart2.addItem("Apple", 1.50, 5);

        assertFalse(cart1.equals(cart2));
    }

    // Test equals with itself
    @Test
    public void testEqualsItself() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        assertTrue(cart.equals(cart));
    }

    // Test hashCode is consistent
    @Test
    public void testHashCodeConsistent() {
        ShoppingCart cart = new ShoppingCart1L();
        cart.addItem("Apple", 1.50, 2);

        int hash1 = cart.hashCode();
        int hash2 = cart.hashCode();

        assertEquals(hash1, hash2);
    }

    // Test hashCode for equal carts is same
    @Test
    public void testHashCodeEqualCarts() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        cart1.addItem("Apple", 1.50, 2);
        cart2.addItem("Apple", 1.50, 2);

        assertEquals(cart1.hashCode(), cart2.hashCode());
    }

    // Test hashCode for empty carts
    @Test
    public void testHashCodeEmpty() {
        ShoppingCart cart1 = new ShoppingCart1L();
        ShoppingCart cart2 = new ShoppingCart1L();

        assertEquals(cart1.hashCode(), cart2.hashCode());
    }
}