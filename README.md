Java E-Commerce Application

This Java-based e-commerce application demonstrates the principles of object-oriented programming (OOP) and incorporates collections, inheritance, polymorphism, and exception handling. The application models products, orders, and order details while handling errors using custom exceptions.

 Features

1. Defines Classes:
    - Product: Represents a product with properties such as Product ID, Name, Category, Price, and Stock Quantity.
    - Order: Represents a customer order with properties like Order ID, User ID, and a list of Order Details.
    - OrderDetails: Contains details of a specific product in an order, including Order Detail ID, Order ID, Product ID, Quantity, and SubTotal.

2. Implements Object-Oriented Programming (OOP) Principles:
    - Inheritance: The Product class is extended into two specific product types, Electronics and Clothing, each with additional properties.
    - Polymorphism: The `calculateDiscount()` method is overridden in both Electronics and Clothing classes to provide specific discount logic for each product type.

3. Uses Java Collections:
    - Orders are stored in an `ArrayList<Order>`.
    - A `HashMap<Integer, Order>` is used to store user order history, where the key is the User ID and the value is the corresponding Order.

4. Exception Handling:
    - A custom exception `OutOfStockException` is thrown when there is insufficient stock to fulfill an order.



