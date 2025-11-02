package components;

import components.standard.Standard;

/**
 * Shopping cart kernel component with primary methods. The kernel provides the
 * minimal functionality needed to operate a shopping cart.
 *
 * @mathmodel type ShoppingCart is modeled by ( items: finite set of ITEM,
 *            quantities: ITEM -> integer )
 *
 * @initially <pre>
 * ensures
 *   this.items = {} and
 *   this.quantities = {}
 * </pre>
 *
 * @author Zayed Ali
 */
public interface ShoppingCartKernel extends Standard<ShoppingCart> {

    /**
     * Adds an item to the shopping cart with the specified name, price, and
     * quantity.
     *
     * @param name
     *            the name of the item
     * @param price
     *            the price of the item
     * @param quantity
     *            the quantity of the item
     * @requires price >= 0.0 and quantity > 0
     * @ensures this = #this with (name, price, quantity) added to items
     * @updates this
     */
    void addItem(String name, double price, int quantity);

    /**
     * Removes an item from the shopping cart by name.
     *
     * @param name
     *            the name of the item to remove
     * @requires name is in this.items
     * @ensures this = #this with item named 'name' removed
     * @updates this
     */
    void removeItem(String name);

    /**
     * Returns the total price of all items in the shopping cart.
     *
     * @return the total price
     * @ensures getTotalPrice = sum of (price * quantity) for all items in this
     */
    double getTotalPrice();

    /**
     * Returns the number of distinct items in the shopping cart.
     *
     * @return the number of items
     * @ensures size = |this.items|
     */
    int size();

    /**
     * Checks if the shopping cart contains an item with the given name.
     *
     * @param name
     *            the name of the item
     * @return true if the item exists in the cart, false otherwise
     * @ensures contains = (name is in this.items)
     */
    boolean contains(String name);
}
