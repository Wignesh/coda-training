//6. Write a program to prove the order of initialization for static block.

package Ex.Lab2;

public class Ex6 {

    Ex6() {
        System.out.println("This will be called after static");
    }

    public static void main(String[] args) {
        // this called after any static block
        new Ex6();
    }

    static {
        // this called first
        System.out.println("Static will be called first ");
    }
}
