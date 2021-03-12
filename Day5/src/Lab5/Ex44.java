/**
 * 44. Write a program to swap two arrays without using temporary variable.
 */
package Lab5;

import java.util.Arrays;

public class Ex44 {
    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 4}};
        swapArrays(array[0], array[1]);
        System.out.println(Arrays.deepToString(array));
    }

    public static void swapArrays(int[] a, int[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] + b[i];
                b[i] = a[i] - b[i];
                a[i] = a[i] - b[i];
            }
        } else {
            System.out.println("Can't swap invalid dimensions");
        }
    }
}
