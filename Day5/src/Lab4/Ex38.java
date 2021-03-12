/**
 * 38. Write a program for Fibonacci series
 * (Hint :Give number is 6. To print this format 0 1 1 2 3 5)
 */
package Lab4;

public class Ex38 {
    public static void main(String[] args) {
        int s = 1, n = 6, f1 = 0, f2 = 1;
        while (s <= n) {
            System.out.print(f1 + " ");

            int sum = f1 + f2;
            f1 = f2;
            f2 = sum;

            s++;
        }
    }
}
