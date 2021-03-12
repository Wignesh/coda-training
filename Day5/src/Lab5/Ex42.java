/**
 * 42. Write a program to print array elements in reverse order.
 */
package Lab5;

public class Ex42 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");

        }
    }
}
