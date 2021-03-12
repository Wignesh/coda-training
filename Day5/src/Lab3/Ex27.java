/**
 * 27. What are the three categories of control statements?
 * Conditional -
 * if
 * if-else
 * if-else-if
 * Switch
 * Looping -
 * for - entry
 * while - entry
 * do-while - exit
 * Unconditional -
 * break -
 * continue -
 */
package Lab3;

public class Ex27 {
    public static void main(String[] args) {
        // if - true block exec
        if (1 == 1)
            System.out.println("Hello True");
        // if - true (if block exec) false (else block exec)
        if (1 > 2) {
            System.out.println("Hello False");
        } else {
            System.out.println("Hello True");
        }
        // if-else-if
        int i = 0;
        if (i > 0) {
            System.out.println("+ve");
        } else if (i < 0) {
            System.out.println("-ve");
        } else {
            System.out.println("0");
        }
        // switch
        char c = 'a';
        switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> System.out.println("Vowel");
            default -> System.out.println("Consonant");
        }
        // for loop
        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        }
        // while loop
        int k = 1;
        while (k < 5) {
            System.out.println(k);
            k++;
        }
        int l = 1;
        do {
            System.out.println(l);
            l++;
        } while (l < 5);

        // break
        for (int m = 5; m < 10; m++) {
            if (m == 8)
                break;
            System.out.println(m);
        }
        // continue
        for (int n = 5; n < 15; n++) {
            if (n % 2 != 0)
                continue;
            System.out.print(n + " ");
        }
    }
}
