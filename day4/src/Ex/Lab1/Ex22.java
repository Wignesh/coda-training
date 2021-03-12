//22. Create a class with public, private, protected, and default data
//members and method members. Create an object of this class and
//see what kind of compiler messages you get when you try to access
//all the class members from out side this class

package Ex.Lab1;

public class Ex22 {
    public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.println(emp.age);
        // can't access private outside
        // System.out.println(emp.name);
        System.out.println(emp.isWorking);
        System.out.println(emp.gender);
    }
}

class Employee {
    private String name;
    public int age;
    protected boolean isWorking;
    char gender;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected boolean isWorking() {
        return isWorking;
    }

    protected void setWorking(boolean working) {
        isWorking = working;
    }

    char getGender() {
        return gender;
    }

    void setGender(char gender) {
        this.gender = gender;
    }

}