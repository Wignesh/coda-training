package ga.veee.day13.Lab;

import java.util.TreeSet;

public class Ex11 {
    public static void main(String[] args) {
        TreeSet<String> s = new TreeSet<String>();
        TreeSet<String> subs = new TreeSet<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        s.add("e");
        subs = (TreeSet) s.subSet("b", true, "d", true);
        s.add("g");
        s.pollFirst();
        s.pollFirst();
        s.add("c2");
        System.out.println(s.size() + " " + subs.size());
        /**
         * A. The size of s is 4
         * [x] B. The size of s is 5
         * C. The size of s is 7
         * D. The size of subs is 1
         * E. The size of subs is 2
         * [x] F. The size of subs is 3
         * G. The size of subs is 4
         */
    }
}
