public class OrderDetails {
    private int orderDetailID;
    private int orderID;
    private Product product;
    private int quantity;
    private double subTotal;

    public OrderDetails(int orderDetailID, int orderID, Product product, int quantity) throws OutOfStockException {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;

        product.reduceStock(quantity); // This will throw an exception if stock is insufficient

        this.subTotal = quantity * product.getPrice();
    }

    public double getSubTotal() {
        return subTotal;

    }
}
