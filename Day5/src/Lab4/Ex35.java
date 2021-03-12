/**
 * 35. Write a program to find midpoint of 100 and 200?
 */
package Lab4;

public class Ex35 {
    public static void main(String[] args) {
        int a = 100, b = 200;
        System.out.println(getMidPoint(a, b));
    }

    private static int getMidPoint(int a, int b) {
        return (a + b) / 2;
    }
}
