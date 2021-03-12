//23. Create a class with protected data. Create a second class in the
//same file with a method that manipulates the protected data in the
//first class

package Ex.Lab1;

public class Ex23 {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setWorking(true);
        System.out.println(emp.isWorking());
    }
}

class Employee2 {
    protected boolean isWorking;
}

class Emp extends Employee2 {
    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}