/**
 * 39. Write multiplication tables using do-while loop?
 */
package Lab4;

public class Ex39 {
    public static void main(String[] args) {
        int num = 5, i = 1;
        do {
            System.out.printf("%d * %d = %d \n", i, num, num * i);
            i++;
        } while (i <= 10);
    }
}
