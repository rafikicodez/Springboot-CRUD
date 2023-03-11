import java.util.ArrayList;
import java.util.List;

public class Food {
    private int id;
    private String name;
    private String description;
    private double price;

    // Constructor
    public Food(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class RestaurantOMS {
    private List<Food> menu;

    // Constructor
    public RestaurantOMS() {
        menu = new ArrayList<>();
    }

    // Create a new food item
    public void createFood(Food item) {
        menu.add(item);
    }

    // Read all food items
    public List<Food> readMenu() {
        return menu;
    }

    // Read a specific food item by ID
    public Food readFoodItem(int id) {
        for (Food item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item not found
    }

    // Update a food item's price and/or description
    public void updateFood(int id, String newDescription, double newPrice) {
        Food item = readFoodItem(id);
        if (item != null) {
            if (newDescription != null) {
                item.setDescription(newDescription);
            }
            if (newPrice > 0) {
                item.setPrice(newPrice);
            }
        }
    }

    // Delete a food item by ID
    public void deleteFoodItem(int id) {
        Food item = readFoodItem(id);
        if (item != null) {
            menu.remove(item);
        }
    }
}