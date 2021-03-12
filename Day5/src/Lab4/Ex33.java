/**
 * 33. Write a program to find even number up to range?
 */
package Lab4;

public class Ex33 {
    public static void main(String[] args) {
        printEvens(1, 49);
    }

    public static void printEvens(int start, int end) {
        start = start % 2 == 0 ? start : start + 1;

        while (start <= end) {
            System.out.println(start);
            start += 2;
        }


    }
}
