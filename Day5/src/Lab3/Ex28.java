/**
 * 28. Write a program that uses an if-else-if ladder to determine which season a particular month is in?
 */
package Lab3;

public class Ex28 {
    public static void main(String[] args) {
        int month = 12;
        if (month >= 3 && month <= 5)
            System.out.println("Spring");
        else if (month >= 6 && month <= 8)
            System.out.println("Summer");
        else if (month >= 9 && month <= 11)
            System.out.println("Fall");
        else
            System.out.println("Winter");
    }
}
