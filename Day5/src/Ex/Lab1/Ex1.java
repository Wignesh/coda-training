//1.Write a Java program to swap two variables, Without using third variable
package Ex.Lab1;

public class Ex1 {
    public static void main(String[] args) {
        int x, y;
        x = 1;
        y = 2;
        System.out.println("A,B = " + x + " " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("A,B = " + x + " " + y);
    }

}
