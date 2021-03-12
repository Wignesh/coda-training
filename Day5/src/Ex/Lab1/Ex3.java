//3.Write a Program to reverse a string.
package Ex.Lab1;

public class Ex3 {
    public static void main(String[] args) {
        String s = "VIGNESH";
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
