package components;
import components.standard.Standard;

/**
 * Enhanced shopping cart component with secondary methods.
 *
 * @author Zayed Ali
 */
public interface ShoppingCart extends ShoppingCartKernel , Standard<ShoppingCart> {

    /**
     * Checks if the shopping cart is empty.
     *
     * @return true if the cart has no items
     * @ensures isEmpty = (this.size() = 0)
     */
    boolean isEmpty();

    /**
     * Updates the quantity of an existing item.
     *
     * @param name the item name
     * @param newQuantity the new quantity
     * @requires name is in cart and newQuantity > 0
     * @ensures quantity of item 'name' = newQuantity
     * @updates this
     */
    void updateQuantity(String name, int newQuantity);

    /**
     * Returns the quantity of a specific item.
     *
     * @param name the item name
     * @return the quantity
     * @requires name is in cart
     * @ensures getQuantity = quantity of item 'name'
     */
    int getQuantity(String name);

    /**
     * Applies a discount to the total.
     *
     * @param discountPercent discount percentage (0-100)
     * @return discounted total
     * @requires 0 <= discountPercent <= 100
     * @ensures result = getTotalPrice() * (1 - discountPercent/100)
     */
    double getDiscountedTotal(double discountPercent);
}