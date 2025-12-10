package components.standard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import components.ShoppingCart;
import components.standard.ShoppingCartSecondary;

/**
 * {@code ShoppingCart} represented as a {@code HashMap} with implementations of
 * primary methods.
 *
 * @convention
 *   All item names in $this.rep are non-null and non-empty strings.
 *   All prices >= 0.0 and all quantities > 0.
 *   No null values in the map.
 *
 * @correspondence
 *   this = (items: keys of $this.rep,
 *           quantities: name - $this.rep.get(name).quantity,
 *           prices:name$this.rep.get(name).price)
 *
 * @author Zayed Ali
 */
public class ShoppingCart1L extends ShoppingCartSecondary implements Iterable<String> {

    /*
     * Private members
     */

    /**
     * Inner class to represent an item in the shopping cart.
     */
    private static class Item {
        String name;
        double price;
        int quantity;

        Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    /**
     * Representation of {@code this}.
     */
    private Map<String, Item> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new HashMap<>();
    }

    /*
     * Constructors
     */

    /**
     * No-argument constructor.
     */
    public ShoppingCart1L() {
        this.createNewRep();
    }

    /*
     * Standard methods
     */

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final ShoppingCart newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void transferFrom(ShoppingCart source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof ShoppingCart1L : ""
                + "Violation of: source is of dynamic type ShoppingCart1L";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        ShoppingCart1L localSource = (ShoppingCart1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods
     */

    @Override
    public final void addItem(String name, double price, int quantity) {
        assert name != null : "Violation of: name is not null";
        assert price >= 0.0 : "Violation of: price >= 0.0";
        assert quantity > 0 : "Violation of: quantity > 0";

        if (this.rep.containsKey(name)) {
            // Item already exists, update quantity
            Item existing = this.rep.get(name);
            existing.quantity += quantity;
        } else {
            // New item
            this.rep.put(name, new Item(name, price, quantity));
        }
    }

    @Override
    public final void removeItem(String name) {
        assert name != null : "Violation of: name is not null";
        assert this.rep.containsKey(name) : "Violation of: name is in this";

        this.rep.remove(name);
    }

    @Override
    public final double getTotalPrice() {
        double total = 0.0;
        for (Item item : this.rep.values()) {
            total += item.price * item.quantity;
        }
        return total;
    }

    @Override
    public final int size() {
        return this.rep.size();
    }

    @Override
    public final boolean contains(String name) {
        assert name != null : "Violation of: name is not null";
        return this.rep.containsKey(name);
    }

    @Override
    public final double getPrice(String name) {
        assert name != null : "Violation of: name is not null";
        assert this.rep.containsKey(name) : "Violation of: name is in this";
        return this.rep.get(name).price;
    }

    @Override
    public final int getQuantity(String name) {
        assert name != null : "Violation of: name is not null";
        assert this.rep.containsKey(name) : "Violation of: name is in this";
        return this.rep.get(name).quantity;
    }

    @Override
    public final Iterator<String> iterator() {
        return this.rep.keySet().iterator();
    }
}