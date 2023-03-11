public class FrontOfHouse {
    private int id;
    private String name;
    private String role;
    private int age;

    public FrontOfHouse(int id, String name, String role, int age) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.age = age;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class FrontOfHouseService {
    private List<FrontOfHouse> frontOfHouseList;

    public FrontOfHouseService() {
        this.frontOfHouseList = new ArrayList<>();
    }

    public void create(FrontOfHouse frontOfHouse) {
        this.frontOfHouseList.add(frontOfHouse);
    }

    public FrontOfHouse read(int id) {
        for (FrontOfHouse frontOfHouse : this.frontOfHouseList) {
            if (frontOfHouse.getId() == id) {
                return frontOfHouse;
            }
        }
        return null;
    }

    public void update(int id, FrontOfHouse frontOfHouse) {
        for (int i = 0; i < this.frontOfHouseList.size(); i++) {
            if (this.frontOfHouseList.get(i).getId() == id) {
                this.frontOfHouseList.set(i, frontOfHouse);
                break;
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < this.frontOfHouseList.size(); i++) {
            if (this.frontOfHouseList.get(i).getId() == id) {
                this.frontOfHouseList.remove(i);
                break;
            }
        }
    }
}

// Example usage
FrontOfHouseService frontOfHouseService = new FrontOfHouseService();

// Create a new front of house staff member
FrontOfHouse newFrontOfHouse = new FrontOfHouse(1, "John Doe", "Server", 25);
frontOfHouseService.create(newFrontOfHouse);

// Read an existing front of house staff member
FrontOfHouse existingFrontOfHouse = frontOfHouseService.read(1);
System.out.println(existingFrontOfHouse.getName()); // Output: "John Doe"

// Update an existing front of house staff member
FrontOfHouse updatedFrontOfHouse = new FrontOfHouse(1, "Jane Doe", "Server", 26);
frontOfHouseService.update(1, updatedFrontOfHouse);

// Delete an existing front of house staff member
frontOfHouseService.delete(1);