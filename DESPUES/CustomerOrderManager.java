package DESPUES;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerOrderManager {

    private static final Logger logger = LoggerFactory.getLogger(CustomerOrderManager.class);

    private final List<String> customerList = new ArrayList<>();
    private final List<String> orderList = new ArrayList<>();

    // Adds a customer to the list
    public void addCustomer(String customerName) {
        if (isValidName(customerName)) {
            customerList.add(customerName);
            logger.info("Added customer: {}", customerName);
        } else {
            logger.error("Invalid customer name provided.");
        }
    }

    // Adds an order to the list
    public void addOrder(String order) {
        if (isValidOrder(order)) {
            orderList.add(order);
            logger.info("Order added: {}", order);
        } else {
            logger.error("Invalid order name provided.");
        }
    }

    // Processes all orders for a specific customer
    public void processOrdersForCustomer(String customerName) {
        if (!customerList.contains(customerName)) {
            logger.warn("Customer not found: {}", customerName);
            return;
        }
        logger.info("Processing orders for: {}", customerName);
        for (String order : orderList) {
            logger.info("Processing order: {}", order);
        }
    }

    // Generates a summary report for customers and orders
    public void generateReport() {
        generateCustomerReport();
        generateOrderReport();
    }

    private void generateCustomerReport() {
        logger.info("Customer Report");
        for (String customer : customerList) {
            logger.info("Customer: {}", customer);
        }
    }

    private void generateOrderReport() {
        logger.info("Order Report");
        for (String order : orderList) {
            logger.info("Order: {}", order);
        }
    }

    // Validation methods
    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private boolean isValidOrder(String order) {
        return order != null && !order.trim().isEmpty();
    }

    public static void main(String[] args) {
        CustomerOrderManager manager = new CustomerOrderManager();
        manager.addCustomer("John Doe");
        manager.addCustomer("Jane Smith");
        manager.addOrder("Order1");
        manager.addOrder("Order2");
        manager.processOrdersForCustomer("John Doe");
        manager.generateReport();
    }
}