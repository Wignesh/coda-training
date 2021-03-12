/**
 * 37. Write a program to find sum of digits of a number. (Hint :  12345 = 1+2+3+4+5 = 15)
 */
package Lab4;

public class Ex37 {
    public static void main(String[] args) {
        int number = 12345;
        System.out.println(addNum(number));
    }

    private static int addNum(int number) {
        int rem, sum = 0;

        while (number != 0) {
            rem = number % 10;
            number /= 10;
            sum += rem;
        }

        return sum;
    }
}
