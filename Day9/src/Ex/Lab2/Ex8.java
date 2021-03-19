package Ex.Lab2;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, c, total = 0;
        System.out.println("Enter no of students : ");
        n = scan.nextInt();
        c = n;
        while (n-- != 0) {
            total += getNum(scan);
        }
        System.out.println("Average : " + total / c);

    }

    public static int getNum(Scanner s) {
        try {
            System.out.print("> ");
            return Integer.parseInt(s.next());
        } catch (NumberFormatException e) {
            System.out.println("Re enter a valid number");
            return getNum(s);
        }
    }
}
