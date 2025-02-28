import java.util.*;

public class ECommerceSysteme {
    private List<Order> ordersList = new ArrayList<>(); // Stores all orders
    private Map<Integer, List<Order>> userOrders = new HashMap<>(); // Maps users to their orders

    public void placeOrder(Order order) {
        // Add order to list
        ordersList.add(order);

        // Add order to user history
        userOrders.computeIfAbsent(order.getUserID(), k -> new ArrayList<>()).add(order);

        System.out.println("Order placed successfully: " + order);
    }

    public void displayUserOrders(int userID) {
        List<Order> orders = userOrders.getOrDefault(userID, Collections.emptyList());
        System.out.println("Orders for User " + userID + ": " + orders);
    }
}

