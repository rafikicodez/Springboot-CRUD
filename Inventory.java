import java.util.ArrayList;
import java.util.List;

public class Inventory{
    private int id;
    private String name;
    private int quantity;

    // Constructor
    public Inventory(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class RestaurantOMS {
    private List<Inventory> inventory;

    // Constructor
    public RestaurantOMS() {
        inventory = new ArrayList<>();
    }

    // Create a new inventory item
    public void createInventory(Inventory item) {
        inventory.add(item);
    }

    // Read all inventory items
    public List<Inventory> readInventory() {
        return inventory;
    }

    // Read a specific inventory item by ID
    public Inventory readInventoryItem(int id) {
        for (Inventory item : inventory) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item not found
    }

    // Update an inventory item's quantity
    public void updateInventoryQuantity(int id, int newQuantity) {
        Inventory item = readInventoryItem(id);
        if (item != null) {
            item.setQuantity(newQuantity);
        }
    }

    // Delete an inventory item by ID
    public void deleteInventoryItem(int id) {
        Inventory item = readInventoryItem(id);
        if (item != null) {
            inventory.remove(item);
        }
    }
}