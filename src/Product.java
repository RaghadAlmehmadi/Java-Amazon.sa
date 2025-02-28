
class Product {
    protected int productID;
    protected String name;
    protected String category;
    protected double price;
    protected int stockQuantity;

    // Constructor
    public Product(int productID, String name, String category, double price, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and Setters
    public int getProductID() { return productID; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setPrice(double price) { this.price = price; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    // Polymorphic method for discount calculation
    public double calculateDiscount() {
        return 0; // No discount by default
    }

    @Override
    public String toString() {
        return name + " (Category: " + category + ", Price: $" + price + ")";
    }
    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > stockQuantity) {
            throw new OutOfStockException("Not enough stock for " + name + "! Requested: " + quantity + ", Available: " + stockQuantity);
        }
        this.stockQuantity -= quantity;
    }

}

// Electronics Subclass
class Electronics extends Product {
    private int warrantyPeriod; // in months

    public Electronics(int productID, String name, double price, int stockQuantity, int warrantyPeriod) {
        super(productID, name, "Electronics", price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() { return warrantyPeriod; }

    // Override the discount method
    @Override
    public double calculateDiscount() {
        return price * 0.2;
    }

    @Override
    public String toString() {
        return super.toString() + " [Warranty: " + warrantyPeriod + " months]";
    }
}

// Clothing Subclass
class Clothing extends Product {
    private String size;
    private String material;

    public Clothing(int productID, String name, double price, int stockQuantity, String size, String material) {
        super(productID, name, "Clothing", price, stockQuantity);
        this.size = size;
        this.material = material;
    }

    public String getSize() { return size; }
    public String getMaterial() { return material; }

    // Override the discount method
    @Override
    public double calculateDiscount() {
        return price * 0.5;
    }

    @Override
    public String toString() {
        return super.toString() + " [Size: " + size + ", Material: " + material + "]";
    }

}
