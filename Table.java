import java.util.ArrayList;
import java.util.List;

public class Table {
    private int id;
    private int capacity;
    private boolean isOccupied;

    // Constructor
    public Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.isOccupied = false;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}

public class RestaurantOMS {
    private List<Table> tables;

    // Constructor
    public RestaurantOMS() {
        tables = new ArrayList<>();
    }

    // Create a new table
    public void createTable(Table table) {
        tables.add(table);
    }

    // Read all tables
    public List<Table> readTables() {
        return tables;
    }

    // Read a specific table by ID
    public Table readTable(int id) {
        for (Table table : tables) {
            if (table.getId() == id) {
                return table;
            }
        }
        return null; // Table not found
    }

    // Update a table's capacity
    public void updateTableCapacity(int id, int newCapacity) {
        Table table = readTable(id);
        if (table != null) {
            table.setCapacity(newCapacity);
        }
    }

    // Delete a table by ID
    public void deleteTable(int id) {
        Table table = readTable(id);
        if (table != null) {
            tables.remove(table);
        }
    }

    // Set a table as occupied
    public void setTableOccupied(int id) {
        Table table = readTable(id);
        if (table != null) {
            table.setOccupied(true);
        }
    }

    // Set a table as unoccupied
    public void setTableUnoccupied(int id) {
        Table table = readTable(id);
        if (table != null) {
            table.setOccupied(false);
        }
    }
}