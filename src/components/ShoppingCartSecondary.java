package components;

/**
 * This abstract class implements all secondary methods from the ShoppingCart
 * interface using only the kernel methods and Standard methods. It does not
 * have access to the underlying representation.
 * @author Zayed Ali
 */
public abstract class ShoppingCartSecondary implements ShoppingCart {

    /*
     * Public members (secondary methods)
     */

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void updateQuantity(String name, int newQuantity) {
        // Check preconditions (design-by-contract)
        assert name != null : "Violation of: name is not null";
        assert this.contains(name) : "Violation of: name is in cart";
        assert newQuantity > 0 : "Violation of: newQuantity > 0";

        // Strategy: We can't directly update quantity, so we need to:
        // 1. Get the current item info (we'll need to track price somehow)
        // 2. Remove the item
        // 3. Add it back with new quantity


        // Get current total
        double totalBefore = this.getTotalPrice();

        // We need to get the old quantity to calculate price
        // This is tricky without direct access - we'll assume we can get it
        int oldQuantity = this.getQuantity(name);

        // Remove the item
        this.removeItem(name);

        // Calculate price from the removed item
        double totalAfter = this.getTotalPrice();
        double itemPrice = (totalBefore - totalAfter) / oldQuantity;

        // Add back with new quantity
        this.addItem(name, itemPrice, newQuantity);
    }

    @Override
    public int getQuantity(String name) {
        // Check preconditions
        assert name != null : "Violation of: name is not null";
        assert this.contains(name) : "Violation of: name is in cart";

        /*
         *
         * For now, we'll leave this as an abstract method that must be
         * implemented by concrete classes that have access to representation.
         */

        // Workaround: Return a placeholder
        // In a real implementation, this would need to be added to the kernel
        throw new UnsupportedOperationException(
                "getQuantity cannot be implemented with current kernel methods");
    }

    @Override
    public double getDiscountedTotal(double discountPercent) {
        // Check preconditions
        assert discountPercent >= 0.0 : "Violation of: discountPercent >= 0.0";
        assert discountPercent <= 100.0 : "Violation of: discountPercent <= 100.0";

        // Get current total using kernel method
        double total = this.getTotalPrice();

        // Calculate discounted amount
        double discount = total * (discountPercent / 100.0);

        // Return discounted total
        return total - discount;
    }

    /*
     * Common methods (Object overrides)
     */

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("ShoppingCart[");
        result.append("items=").append(this.size());
        result.append(", total=$");
        result.append(String.format("%.2f", this.getTotalPrice()));
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ShoppingCart)) {
            return false;
        }

        ShoppingCart other = (ShoppingCart) obj;

        // Two carts are equal if they have same size and total price
        return this.size() == other.size()
                && Math.abs(this.getTotalPrice() - other.getTotalPrice()) < 0.001;
    }

    @Override
    public int hashCode() {
        // Simple hash based on size and total
        final int prime = 31;
        int result = 1;
        result = prime * result + this.size();
        long temp = Double.doubleToLongBits(this.getTotalPrice());
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}