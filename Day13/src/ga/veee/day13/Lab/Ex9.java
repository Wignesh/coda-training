package ga.veee.day13.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex9 {
    public static void main(String[] args) {
        Object o = new Object();
        // insert code here
        Set s = new HashSet();
//        TreeSet s = new TreeSet();
//        LinkedHashSet s = new LinkedHashSet();
        s.add("o");
        s.add(o);
        /**
         * [x] A. Fragment I compile
         * [x] B. Fragment II compiles
         * [x] C. Fragment III compiles
         * [x] D. Fragment I executes without exception
         * E. Fragment II executes without exception
         * [x] F. Fragment III executes without exception
         */
    }
}
