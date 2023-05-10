import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Restaurant {
    private String name;
    private List<String> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void addMenuItem(String menuItem) {
        menu.add(menuItem);
    }
}

class Order {
    private String customerName;
    private String restaurantName;
    private List<String> items;

    public Order(String customerName, String restaurantName, List<String> items) {
        this.customerName = customerName;
        this.restaurantName = restaurantName;
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public List<String> getItems() {
        return items;
    }
}

class RestaurantManager {
    private Map<String, Restaurant> restaurants;
    private List<Order> orders;

    public RestaurantManager() {
        restaurants = new HashMap<>();
        orders = new ArrayList<>();
    }

    public void addRestaurant(String name) {
        Restaurant restaurant = new Restaurant(name);
        restaurants.put(name, restaurant);
    }

    public void addMenuItem(String restaurantName, String menuItem) {
        Restaurant restaurant = restaurants.get(restaurantName);
        if (restaurant == null) {
            System.out.println("Restaurant not found!");
            return;
        }
        restaurant.addMenuItem(menuItem);
    }

    public void placeOrder(String customerName, String restaurantName, List<String> items) {
        Order order = new Order(customerName, restaurantName, items);
        orders.add(order);
        System.out.println("Order placed successfully!");
    }

    public List<Order> getOrdersByCustomer(String customerName) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    public List<Order> getOrdersByRestaurant(String restaurantName) {
        List<Order> restaurantOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getRestaurantName().equals(restaurantName)) {
                restaurantOrders.add(order);
            }
        }
        return restaurantOrders;
    }
}

public class Main {
    public static void main(String[] args) {
        RestaurantManager manager = new RestaurantManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to add a restaurant");
            System.out.println("Enter 2 to add a menu item");
            System.out.println("Enter 3 to place an order");
            System.out.println("Enter 4 to view customer orders");
            System.out.println("Enter 5 to view restaurant orders");
            System.out.println("Enter 0 to exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the restaurant:");
                    String restaurantName = scanner.nextLine();
                    manager.addRestaurant(restaurantName);
                    System.out.println("Restaurant added successfully!");
                    break;
                case 2:
                    System.out.println("Enter the name of the restaurant:");
                    restaurantName = scanner.nextLine();
                    System.out.println("Enter the name of the menu item:");
                    String menuItem = scanner.nextLine();
                    manager.addMenuItem(restaurantName, menuItem);
                    System.out.println("Menu item added successfully!");
                     break;
                case 3:
                     System.out.println("Enter your name:");
                     String customerName = scanner.nextLine();
                     System.out.println("Enter the name of the restaurant:");
                     restaurantName = scanner.nextLine();
                     System.out.println("Enter the name of the menu item:");
                     menuItem = scanner.nextLine();
                     System.out.println("Enter the quantity:");
                     int quantity = scanner.nextInt();
                     scanner.nextLine();
                     manager.placeOrder(customerName, restaurantName, menuItem, quantity);
                     System.out.println("Order placed successfully!");
                     break;
                case 4:
                     System.out.println("Enter your name:");
                     customerName = scanner.nextLine();
                     manager.viewCustomerOrders(customerName);
                     break;
                case 5:
                     System.out.println("Enter the name of the restaurant:");
                     restaurantName = scanner.nextLine();
                     manager.viewRestaurantOrders(restaurantName);
                     break;
                case 0:
                     System.exit(0);
                default:
                     System.out.println("Invalid choice. Try again.");
              }
        }
    }
}
