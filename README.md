# ShoppingCart Component

A software component implementing a shopping cart in the OSU software sequence discipline. This component provides a robust, contract-based API for managing shopping cart operations with a HashMap-based implementation.

## Component Overview

The **ShoppingCart** component models a shopping cart that can hold multiple items, each with a name, price, and quantity. It follows the OSU software discipline with formal contracts, separation of kernel and secondary methods, and layered implementations.

### Features

- Add, remove, and update items in the cart
- Calculate total price with optional discounts
- Query cart contents (size, contains, item details)
- Full design-by-contract specifications
- Comprehensive JUnit test coverage
- Iterator support for traversing items

## Component Structure

```
src/components/
├── ShoppingCartKernel.java          # Kernel interface (minimal operations)
├── ShoppingCart.java                 # Enhanced interface (secondary methods)
└── standard/
    ├── ShoppingCartSecondary.java   # Abstract class with layered implementations
    ├── ShoppingCart1L.java          # HashMap-based kernel implementation
    └── Standard.java                # Standard interface for all components

test/
├── ShoppingCart1LTest.java          # Tests for kernel methods (50+ test cases)
└── ShoppingCartTest.java            # Tests for secondary methods (30+ test cases)
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- JUnit 4.13.2 (included in `lib/`)
- Hamcrest Core 1.3 (included in `lib/`)
- Components library (included in `lib/`)

### Example Usage

```java
import components.ShoppingCart;
import components.standard.ShoppingCart1L;

public class Example {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart1L();

        // Add items
        cart.addItem("Apple", 0.99, 5);
        cart.addItem("Banana", 0.59, 3);

        // Get total
        double total = cart.getTotalPrice(); // 6.72

        // Apply discount
        double discounted = cart.getDiscountedTotal(10.0); // 6.048

        // Check contents
        System.out.println(cart.size()); // 2
        System.out.println(cart.contains("Apple")); // true

        // Update quantity
        cart.updateQuantity("Apple", 10);
        System.out.println(cart.getQuantity("Apple")); // 10
    }
}
```

### Use Cases

Two demonstration programs are provided in `src/`:

1. **GroceryCheckout.java** - Simple grocery store checkout system demonstrating basic cart operations (add, update, remove items, apply discounts)
2. **OnlineStoreDemo.java** - Advanced online shopping demo with membership tiers (Bronze/Silver/Gold) showcasing different discount scenarios and bulk purchases

Run these files to see the component in action!

## Running Tests

Tests use JUnit 4. In VSCode with the Java Test Runner extension:

1. Open the Testing sidebar (beaker icon)
2. Click the play button to run all tests
3. View detailed results in the Test Explorer

All test files include comprehensive edge cases:

- Empty cart operations
- Single and multiple item scenarios
- Boundary values (zero prices, maximum quantities)
- State verification after operations

## Design Decisions

- **Representation**: HashMap chosen for O(1) average-case lookup performance by item name
- **Item Storage**: Internal `Item` class encapsulates name, price, and quantity as a single unit
- **Quantity Accumulation**: When adding an existing item, quantities are accumulated rather than replaced
- **Secondary Methods**: All secondary methods are layered on kernel methods following OSU discipline principles
- **Immutability**: Item names serve as immutable keys; prices and quantities can be modified

## API Documentation

Complete documentation for all methods is available in the source code using JavaDoc format. Key contracts include:

### Kernel Methods

- **addItem(name, price, quantity)**: Requires price ≥ 0.0 and quantity > 0
- **removeItem(name)**: Requires item exists in cart
- **getTotalPrice()**: Returns sum of (price × quantity) for all items
- **size()**: Returns number of distinct items
- **contains(name)**: Checks if item exists
- **getPrice(name)**: Requires item exists; returns item price
- **getQuantity(name)**: Requires item exists; returns item quantity

### Secondary Methods

- **isEmpty()**: Returns true if cart has no items
- **updateQuantity(name, newQuantity)**: Requires item exists and newQuantity > 0
- **getDiscountedTotal(discountPercent)**: Requires 0 ≤ discountPercent ≤ 100

### Standard Methods

- **clear()**: Removes all items
- **newInstance()**: Creates a new empty cart
- **transferFrom(source)**: Transfers contents from source to this

## Testing Coverage

- **ShoppingCart1LTest.java**: 50+ test cases covering all kernel methods
- **ShoppingCartTest.java**: 30+ test cases covering all secondary methods
- Edge cases include: empty carts, single items, multiple items, boundary values, state verification

## Author

**Zayed Ali**

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

Created to learn and have fun by building this project. This could have happened
only with the help of Dr Jeremy Grifski.
