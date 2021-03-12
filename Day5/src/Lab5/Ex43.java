/**
 * 43. Write a program to find Biggest and Lowest element of an array.
 */
package Lab5;

public class Ex43 {
    public static void main(String[] args) {
        int[] a = {8, 2, 3, 4, 5};
        int l = a[0], s = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (a[i] < s)
                s = a[i];

            if (a[i] > l)
                l = a[i];
        }

        System.out.println(s);
        System.out.println(l);
    }
}
