package components.standard;

/**
 * Layered implementations of secondary methods for {@code ShoppingCart}.
 *
 * @author Zayed Ali
 */
public abstract class ShoppingCartSecondary implements components.ShoppingCart, Iterable<String> {

    /*
     * Common methods (from Object)
     */

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof components.ShoppingCart)) {
            return false;
        }
        components.ShoppingCart s = (components.ShoppingCart) obj;
        if (this.size() != s.size()) {
            return false;
        }
        // Compare all items
        for (String name : this) {
            if (!s.contains(name) ||
                this.getQuantity(name) != s.getQuantity(name) ||
                this.getPrice(name) != s.getPrice(name)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (String name : this) {
            hash += name.hashCode() + this.getQuantity(name);
        }
        return hash;
    }

    @Override
    public final String toString() {
        StringBuilder result = new StringBuilder("ShoppingCart[");
        boolean first = true;
        for (String name : this) {
            if (!first) {
                result.append(", ");
            }
            result.append(name).append(":$").append(this.getPrice(name))
                  .append("x").append(this.getQuantity(name));
            first = false;
        }
        result.append("]");
        return result.toString();
    }

    /*
     * Secondary methods implementation
     */

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final void updateQuantity(String name, int newQuantity) {
        assert this.contains(name) : "Violation of: name is in this";
        assert newQuantity > 0 : "Violation of: newQuantity > 0";

        double price = this.getPrice(name);
        this.removeItem(name);
        this.addItem(name, price, newQuantity);
    }

    @Override
    public final double getDiscountedTotal(double discountPercent) {
        assert discountPercent >= 0 && discountPercent <= 100 :
            "Violation of: 0 <= discountPercent <= 100";

        return this.getTotalPrice() * (1.0 - discountPercent / 100.0);
    }
}