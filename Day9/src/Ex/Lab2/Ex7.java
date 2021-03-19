package Ex.Lab2;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String num = sc.next();
            if (Character.toLowerCase(num.charAt(0)) == 'q') {
                break;
            }
            String div = sc.next();
            try {
                int r = Integer.parseInt(num) / Integer.parseInt(div);
                System.out.println(r);
            } catch (ArithmeticException ae) {
                System.out.println("Numerator must be > 0");
            } catch (NumberFormatException ne) {
                System.out.println("Poor input data");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
