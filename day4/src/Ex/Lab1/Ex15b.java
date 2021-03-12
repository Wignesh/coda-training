// 15.
// b) To check given number is an Armstrong number or perfect number
// or palindrome or none of these

package Ex.Lab1;

public class Ex15b {
    public static void main(String[] args) {
        checkNumber(11);
    }

    private static void checkNumber(int number) {
        boolean isWorks = false;
        if (isArmstrong(number)) {
            isWorks = true;
            System.out.println("It's a Armstrong number");
        }
        if (isPalindrome(number)) {
            isWorks = true;
            System.out.println("It's a Palindrome number");
        }
        if (isPerfect(number)) {
            isWorks = true;
            System.out.println("It's a Perfect number");
        }
        if (!isWorks)
            System.out.println("None of those number");

    }

    private static boolean isPerfect(int number) {
        int sum = 0, i = 1;
        while (i <= number / 2) {
            if (number % i == 0) {
                sum += i;
            }
            i++;
        }
        return sum == number;
    }

    private static boolean isPalindrome(int number) {
        int rInt = 0, rem, num = number;

        while (number != 0) {
            rem = number % 10;
            rInt = rInt * 10 + rem;
            number /= 10;
        }

        return num == rInt;
    }

    private static boolean isArmstrong(int number) {
        int num = number, rem, result = 0;

        while (num != 0) {
            rem = num % 10;
            result += Math.pow(rem, 3);
            num /= 10;
        }

        return result == number;
    }

}
