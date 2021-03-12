/**
 * Write a program for four-function calculator using switch case?(add,sub,mul,div)
 */
package Lab3;

public class Ex31 {

    public static void main(String[] args) {
        double a = 2.4, b = 1.2;
        System.out.println("Add : " + calc(a, b, 1));
        System.out.println("Sub : " + calc(a, b, 2));
        System.out.println("Mul : " + calc(a, b, 3));
        System.out.println("Div : " + calc(a, b, 4));
    }

    public static double calc(double a, double b, int op) {

        return switch (op) {
            case 1 -> add(a, b);
            case 2 -> sub(a, b);
            case 3 -> mul(a, b);
            case 4 -> div(a, b);
            default -> 0.0;
        };

    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        return a / b;
    }
}
