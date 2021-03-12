/**
 * 34. Write a program to find average of odd number below range?
 */
package Lab4;

public class Ex34 {
    public static void main(String[] args) {
        System.out.println(getAvgEvens(3, 9));
    }

    public static int getAvgEvens(int start, int end) {
        int avg = 0, count = 0;
        start = start % 2 == 0 ? start : start + 1;

        while (start <= end) {
            avg += start;
            start += 2;
            count += 1;
        }
        return avg / count;
    }
}
