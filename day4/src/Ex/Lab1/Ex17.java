//17. Write a program to test:
//a) to modify const member
//b) to access static member in a non -static method
//c) create a class with one argument constructor and try to instantiate
//object without parameter

package Ex.Lab1;

public class Ex17 {

    static final int consta = 10;

    public Ex17(int aInt) {
        System.out.println(aInt);
    }

    public static void main(String[] args) {

        // final can't reassign
        // consta = 11;

        // non-static method can't be referenced from static method
        // sayHello();

        // expected constructor not found should have to pass one param
        //Ex17 ex17 = new Ex17();
    }

    private void sayHello() {
        System.out.println("Hello");
    }
}
