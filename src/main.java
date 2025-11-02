import components.ShoppingCartInitial;

public class main {
/**
     * Main method to demonstrate the Shopping Cart component.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a new shopping cart
        ShoppingCartInitial cart = new components.ShoppingCartInitial();


        System.out.println("Shopping Cart Demo \n");

        // Add items to the cart
        System.out.println("Adding items to cart...");
        cart.addItem("Laptop", 999.99, 1);
        cart.addItem("Mouse", 25.50, 2);
        cart.addItem("Keyboard", 75.00, 1);
        cart.addItem("USB Cable", 12.99, 3);
        System.out.println("Items added successfully!\n");

        // View cart contents
        System.out.println("Current cart contents:");
        cart.viewCart();
        System.out.println();

        // Calculate and display total
        System.out.println("Total price: $" +
            String.format("%.2f", cart.getTotalPrice()));
        System.out.println();

        // Demonstrate removing an item
        System.out.println("Removing 'Mouse' from cart...");
        cart.removeItem("Mouse");
        System.out.println();

        // View updated cart
        System.out.println("Updated cart contents:");
        cart.viewCart();
        System.out.println();

        // Display new total
        System.out.println("New total price: $" +
            String.format("%.2f", cart.getTotalPrice()));
        System.out.println();

        // Add another item
        System.out.println("Adding Monitor to cart...");
        cart.addItem("Monitor", 299.99, 1);
        System.out.println();

        // Final cart view
        System.out.println("Final cart contents:");
        cart.viewCart();
        System.out.println();

        System.out.println("Final total: $" +
            String.format("%.2f", cart.getTotalPrice()));

        System.out.println("\n=== Demo Complete ===");
    }
}