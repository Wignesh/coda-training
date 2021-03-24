package ga.veee.day13.Lab;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex3 {
    public static void main(String[] args) {
        // ANS: E. The before() method will throw an exception at runtime
        before();
    }

    public static void before() {
        Set set = new TreeSet();
        set.add("2");
        // Can't
        set.add(3);
        set.add("1");
        Iterator it = set.iterator();
        while (it.hasNext())
            System.out.println(it.next() + "");
    }
}
