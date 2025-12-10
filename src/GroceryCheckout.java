import components.ShoppingCart;
import components.standard.ShoppingCart1L;

/**
 * Demonstration of ShoppingCart component used in a grocery store checkout
 * system.
 *
 * @author Zayed Ali
 */
public final class GroceryCheckout {

    /**
     * Private constructor to prevent instantiation.
     */
    private GroceryCheckout() {
    }

    /**
     * Main method demonstrating grocery checkout use case.
     *
     * @param args
     *            command line arguments (not used)
     */
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart1L();

        System.out.println("--- Grocery Store Checkout System ---\n");

        // Customer adds items to cart
        System.out.println("Adding items to cart...");
        cart.addItem("Apples", 1.99, 3);
        cart.addItem("Bread", 2.50, 2);
        cart.addItem("Milk", 3.25, 1);
        cart.addItem("Eggs", 4.00, 2);

        System.out.println("Items in cart: " + cart.size());
        System.out.println("Total: $" + String.format("%.2f", cart.getTotalPrice()));
        System.out.println();

        // Customer adds more apples
        System.out.println("Adding 2 more apples...");
        cart.addItem("Apples", 1.99, 2);
        System.out.println("Apple quantity: " + cart.getQuantity("Apples"));
        System.out.println("Total: $" + String.format("%.2f", cart.getTotalPrice()));
        System.out.println();

        // Customer changes mind about eggs quantity
        System.out.println("Updating eggs quantity to 1...");
        cart.updateQuantity("Eggs", 1);
        System.out.println("New total: $" + String.format("%.2f", cart.getTotalPrice()));
        System.out.println();

        // Apply store discount
        System.out.println("Applying 10% store discount...");
        double discountedTotal = cart.getDiscountedTotal(10.0);
        System.out.println("Final total: $" + String.format("%.2f", discountedTotal));
        System.out.println();

        // Remove an item
        System.out.println("Customer removes bread from cart...");
        cart.removeItem("Bread");
        System.out.println("Items remaining: " + cart.size());
        System.out.println("New total: $" + String.format("%.2f", cart.getTotalPrice()));
        System.out.println();

        System.out.println("--- Checkout Complete ---");
    }
}