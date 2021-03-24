package ga.veee.day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class CollectionDemo2 {
    public static void main(String[] args) {

        Vector<String> v = new Vector<String >(10,5);
        v.add("aaaa");
        v.add("bbbb");
        v.add("cccc");

        Iterator<String> itr = v.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        Enumeration e = v.elements();
        v.add("dddd");
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }


    }
}
