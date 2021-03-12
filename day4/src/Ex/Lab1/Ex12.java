//12.Write a Program to access command line arguments.

package Ex.Lab1;

public class Ex12 {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello " + args[0]);
        } else {
            System.out.println("Requires at-least one argument to be passed");
            System.out.println("Exit");
            System.exit(0);
        }
    }
}
