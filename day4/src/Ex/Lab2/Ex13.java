//13. Create an abstract class with no abstract methods. Verify that
//you cannot create instances of the class

package Ex.Lab2;


public class Ex13 extends AbClass {
    public static void main(String[] args) {
        // can't init abstract class
        // but can get the parent logic
        // AbClass ab = new AbClass().sayHello();
    }
}

abstract class AbClass {
    public void sayHello() {
        System.out.println("Hello");
    }
}