/**
 * 32. Write a program to determine given number is prime or not?
 * (Hint -Prime number: A number only divided by itself and 1)
 */
package Lab4;

public class Ex32 {
    public static void main(String[] args) {
        System.out.println(isPrime(11));
    }

    public static boolean isPrime(int num) {
        int i = 2;
        boolean flag = false;
        while (i <= num / 2) {
            if (num % i == 0) {
                flag = true;
                break;
            }
            ++i;
        }

        return !flag;
    }

}
