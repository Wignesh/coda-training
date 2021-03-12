/**
 * 40. Write a program to determine given number is prime or not using for loop?
 */
package Lab4;

public class Ex40 {
    public static void main(String[] args) {
        System.out.println(isPrime(29));
        System.out.println(isPrime(290));
    }

    public static boolean isPrime(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return !flag;
    }
}
