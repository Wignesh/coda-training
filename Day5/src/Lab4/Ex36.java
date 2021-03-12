/**
 * 36. Write a program for palindrome using while loop? (write for both string and numbers)
 * (Hint: Given number are 125 to print 521
 * 125 is not a palindrome) or (liril reverse is liril)
 */
package Lab4;

public class Ex36 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1212));
        System.out.println(isPalindrome("liril"));
        System.out.println(isPalindrome("lirisl"));

    }

    public static boolean isPalindrome(int number) {
        int rInt = 0, rem, num = number;

        while (number != 0) {
            rem = number % 10;
            rInt = rInt * 10 + rem;
            number /= 10;
        }

        return num == rInt;
    }

    public static boolean isPalindrome(String string) {
        int i = 0, j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
