package ga.veee.day13.Lab;

import java.util.Arrays;
import java.util.Comparator;

public class Ex15 {
    public static void main(String[] args) {
        String[] s = {"map", "pen", "marble", "key"};
        Ex15.Othello o = new Ex15.Othello();
        Arrays.sort(s, o);
        for (String s2 : s) System.out.print(s2 + " ");
        System.out.println(Arrays.binarySearch(s, "map"));
    }
    static class Othello implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
    /**
     * A. Compilation fails
     * B. The output will contain a 1
     * C. The output will contain a 2
     * [X] D. The output will contain a –1
     * E. An exception is thrown at runtime
     * F. The output will contain "key map marble pen"
     * [X] G. The output will contain "pen marble map key"
     */
}
