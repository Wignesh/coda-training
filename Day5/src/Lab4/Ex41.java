/**
 * 41. Write a program to print the format below using nested for loop
 */
package Lab4;

public class Ex41 {
    public static void main(String[] args) {
        int k = 1, n = 4;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println();
        }
    }
}
