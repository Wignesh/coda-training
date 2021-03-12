/**
 * 47. Write a program for arithmetic operation using method overloading?
 */
package Lab6;

public class Ex47 {
    public static void main(String[] args) {
        Ex47 ex46 = new Ex47();
        System.out.println(ex46.add(1, 2));
        System.out.println(ex46.add(1, 2, 3));
        System.out.println(ex46.add(1, 2, 3, 4));
    }

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
