import components.ShoppingCart;
import components.standard.ShoppingCart1L;

/**
 * Demonstration of ShoppingCart component used in an online shopping platform
 * with membership tiers and discount features.
 *
 * @author Zayed Ali
 */
public final class OnlineStoreDemo {

    /**
     * Private constructor to prevent instantiation.
     */
    private OnlineStoreDemo() {
    }

    /**
     * Simulates processing an order with membership discount.
     *
     * @param cart
     *            the shopping cart
     * @param membershipLevel
     *            the customer's membership level
     */
    private static void processOrder(ShoppingCart cart, String membershipLevel) {
        double discount = 0.0;

        if (membershipLevel.equals("Gold")) {
            discount = 15.0;
        } else if (membershipLevel.equals("Silver")) {
            discount = 10.0;
        } else if (membershipLevel.equals("Bronze")) {
            discount = 5.0;
        }

        System.out.println("Membership: " + membershipLevel);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Subtotal: $" + String.format("%.2f",
            cart.getTotalPrice()));
        System.out.println("Final total: $" + String.format("%.2f",
         cart.getDiscountedTotal(discount)));
    }

    /**
     * Main method demonstrating online store use case.
     *
     * @param args
     *            command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("--- Online Store Shopping Demo ---\n");

        // Scenario 1: Bronze member shopping
        System.out.println("--- Scenario 1: Bronze Member ---");
        ShoppingCart cart1 = new ShoppingCart1L();
        cart1.addItem("Laptop", 899.99, 1);
        cart1.addItem("Mouse", 25.50, 1);
        cart1.addItem("Keyboard", 75.00, 1);

        processOrder(cart1, "Bronze");
        System.out.println();

        // Scenario 2: Gold member with bulk purchase
        System.out.println("--- Scenario 2: Gold Member Bulk Purchase ---");
        ShoppingCart cart2 = new ShoppingCart1L();
        cart2.addItem("T-Shirt", 15.99, 5);
        cart2.addItem("Jeans", 49.99, 3);
        cart2.addItem("Socks", 8.99, 10);

        System.out.println("Initial cart size: " + cart2.size() + " item types");
        processOrder(cart2, "Gold");
        System.out.println();

        // Scenario 3: Customer modifies order
        System.out.println("--- Scenario 3: Order Modification ---");
        ShoppingCart cart3 = new ShoppingCart1L();
        cart3.addItem("Phone Case", 19.99, 2);
        cart3.addItem("Screen Protector", 12.99, 2);
        cart3.addItem("Charger", 29.99, 1);

        System.out.println("Original order total: $" +
        String.format("%.2f", cart3.getTotalPrice()));

        System.out.println("\nCustomer updates phone case quantity to 1...");
        cart3.updateQuantity("Phone Case", 1);

        System.out.println("Customer removes screen protector...");
        cart3.removeItem("Screen Protector");

        System.out.println("\nUpdated cart:");
        processOrder(cart3, "Silver");
        System.out.println();

        // Scenario 4: Empty cart check
        System.out.println("--- Scenario 4: Empty Cart ---");
        ShoppingCart cart4 = new ShoppingCart1L();
        if (cart4.isEmpty()) {
            System.out.println("Cart is empty. Please add items to checkout.");
        }
        System.out.println();

        System.out.println(" Demo Complete ---");
    }
}