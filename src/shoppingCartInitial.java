/**
 * Initial version of Shopping Cart class.
 */
public class shoppingCartInitial {

    /**
     * Inner class representing an item in the shopping cart.
     */
    public static final class Item {

        /**
         * Using String for name of the item.
         */
        private String name;

        /**
         * Using double for price of the item.
         */
        private double price;

        /**
         * Using int for quantity of the item.
         */
        private int quantity;

        /**
         * Constructor for Item class.
         *
         * @param name     Name of the item.
         * @param price    Price of the item.
         * @param quantity Quantity of the item.
         */
        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        /**
         * Getter for name.
         *
         * @return Name of the item.
         */
        public String getName() {
            return this.name;
        }
        /**
         * Getter for price.
         *
         * @return Price of the item.
         */
        public double getPrice() {
            return this.price;
        }

        /**
         * Getter for quantity.
         *
         * @return Quantity of the item.
         */
        public int getQuantity() {
            return this.quantity;
        }
    }

    /**
     * Using ArrayList to store items in the shopping cart.
     */
    private java.util.ArrayList<Item> items;

    /**
     * Constructor for ShoppingCart class.
     */
    public shoppingCartInitial() {
        this.items = new java.util.ArrayList<>();
    }

    /**
     * Method to add an item to the shopping cart.
     *
     * @param item Item to be added.
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Method to get the total price of items in the shopping cart.
     *
     * @return Total price of items.
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (Item item : this.items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    /**
     * Method to view the list of shopping cart items.
     */
    public void viewCart() {
        for (Item item : this.items) {
            System.out.println("Item: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
        }
    }

    /**
     * Method to remove items from shopping cart by name.
     * @param itemName Name of the item to be removed.
     */
    public void removeItem(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            System.out.println("Invalid item name.");
            return;
        }
        else{
            this.items.remove(itemName);
        }
    }
}
