import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Manually assigned user IDs (matching database IDs)
            int user1ID = 3;
            int user2ID = 5;

            // Creating products (IDs matching database)
            Product laptop = new Electronics(1, "Laptop", 999.99, 15, 24);  // 15 units in stock
            Product tShirt = new Clothing(7, "T-Shirt", 19.99, 60, "M", "Cotton");  // 60 units in stock
            // Store available products in a map
            Map<Integer, Product> productCatalog = new HashMap<>();
            productCatalog.put(laptop.getProductID(), laptop);
            productCatalog.put(tShirt.getProductID(), tShirt);

            // Display available products
            System.out.println("Available Products:");
            for (Product product : productCatalog.values()) {
                System.out.println(product.getProductID() + ": " + product);
            }

            // User input for product selection
            System.out.print("Enter product ID to order: ");
            int productId = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            // Validate product selection
            if (!productCatalog.containsKey(productId)) {
                System.out.println("Invalid product ID.");
                return;
            }

            Product selectedProduct = productCatalog.get(productId);

            // Apply discount if applicable
            double discountedPrice = selectedProduct.calculateDiscount();
            double totalPrice = discountedPrice * quantity;
            System.out.println("Discounted price for " + selectedProduct.getName() + ": $" + discountedPrice);
            System.out.println("Total price for " + quantity + " units: $" + totalPrice);

            // Check stock and reduce it using reduceStock method
            selectedProduct.reduceStock(quantity);  // Reduce stock here with validation

            // Create an order for the user
            Order order1 = new Order(1, user1ID);
            order1.addOrderDetail(new OrderDetails(1, order1.getOrderID(), selectedProduct, quantity));

            // Store the order in an ArrayList
            List<Order> orders = new ArrayList<>();
            orders.add(order1);

            // Store user order history in a HashMap
            HashMap<Integer, List<Order>> orderHistory = new HashMap<>();
            orderHistory.put(user1ID, List.of(order1));

            // Display all orders placed by the user
            System.out.println("\nOrder Details:");
            for (Order order : orders) {
                System.out.println(order);
            }

            // Display updated stock
            System.out.println("\nUpdated stock for " + selectedProduct.getName() + ": " + selectedProduct.getStockQuantity() + " units");

        } catch (OutOfStockException e) {
            // Handle insufficient stock error
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
