// 15.
// a) To generate a Prime number list between 1 to 100
package Ex.Lab1;

public class Ex15a {
    public static void main(String[] args) {
        genPrime(1, 100);
    }

    private static void genPrime(int start, int end) {
        while (start < end) {
            boolean found = false;

            for (int i = 2; i <= start / 2; ++i) {
                if (start % i == 0) {
                    found = true;
                    break;
                }
            }

            if (!found && start != 0 && start != 1)
//                System.out.print(start + " ");

            ++start;
        }
    }
}
