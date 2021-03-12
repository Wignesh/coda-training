/**
 * 29. Write a program that uses a switch case to determine given character is vowel or not?
 */
package Lab3;

public class Ex29 {
    public static void main(String[] args) {
        System.out.println(isVowel('v'));
    }

    public static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };

    }
}
