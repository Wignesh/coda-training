//15. Write a program to find the cost of constructing a house
//creating a class called House. Create 2 classes Door and window.
//House has instance of door and window. House has member which
//provide information related to area of construction of door and
//window. House delegates the responsibility of calculating the cost of
//door and window to the respective classes

package Ex.Lab2;

public class Ex15 {
    public static void main(String[] args) {
        House myHouse = new House(40, 20);
        System.out.println("HouseC Cost = " + myHouse.getHouseCost());
    }
}

class House {
    Door door;
    Window window;
    int windowSqft, doorSqft;

    public House(int windowSqft, int doorSqft) {
        this.door = new Door();
        this.window = new Window();
        this.windowSqft = windowSqft;
        this.doorSqft = doorSqft;
    }

    int getHouseCost() {
        return this.door.getCost(this.doorSqft) + this.window.getCost(this.windowSqft);
    }
}

class Door {
    int getCost(int sqft) {
        return sqft * 8;
    }
}

class Window {
    int getCost(int sqft) {
        return sqft * 5;
    }
}