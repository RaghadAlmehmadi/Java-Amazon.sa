import java.util.*;

class Order {
    private int orderID;
    private int userID;
    private List<OrderDetails> orderDetails;

    public Order(int orderID, int userID) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetails = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetails detail) {
        orderDetails.add(detail);
    }

    public double getTotalPrice() {
        return orderDetails.stream().mapToDouble(OrderDetails::getSubTotal).sum();
    }

    public int getUserID() {
        return userID;
    }

    // Add this method to return orderID
    public int getOrderID() {
        return orderID;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderID + ", UserID: " + userID + ", Total: $" + getTotalPrice();
    }
}
