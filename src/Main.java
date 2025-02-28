import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Manually assigned user IDs (matching database IDs)
            int user1ID = 3;
            int user2ID = 5;

            // Creating products (IDs matching database)
            Product laptop = new Electronics(1, "Laptop", 999.99, 15, 24);
            Product tShirt = new Clothing(7, "T-Shirt", 19.99, 60, "M", "Cotton");

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

            // Creating an order
            Order order1 = new Order(1, user1ID);
            order1.addOrderDetail(new OrderDetails(1, order1.getOrderID(), selectedProduct, quantity));

            // Store orders in an ArrayList
            List<Order> orders = new ArrayList<>();
            orders.add(order1);

            // Store user order history in a HashMap
            HashMap<Integer, List<Order>> orderHistory = new HashMap<>();
            orderHistory.put(user1ID, List.of(order1));

            // Display all orders
            for (Order order : orders) {
                System.out.println(order);
            }
        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
