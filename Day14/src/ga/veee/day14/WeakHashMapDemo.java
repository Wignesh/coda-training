package ga.veee.day14;

import java.util.*;

public class WeakHashMapDemo {

    public static void main(String[] args) {
//        Map<String,String > map = new HashMap<String,String>();

//        Map<String, String> map = new TreeMap<String, String>((o1, o2) -> {
//            return o2.compareTo(o1);
//        });

        Map<Emp, String> map = new WeakHashMap<Emp, String>();
        Emp emp1 = new Emp(123);
        Emp emp2 = new Emp(124);
        Emp emp3 = new Emp(125);
        Emp emp4 = new Emp(126);
        map.put(emp1, "Hello");
        map.put(emp2, "Hai");
        map.put(emp3, "World");
        map.put(emp4, "!");

        System.out.println(map);

        emp2 = null;
        System.gc();

        Set<Map.Entry<Emp, String>> s = map.entrySet();
        Iterator<Map.Entry<Emp, String>> iter = s.iterator();
        while (iter.hasNext()) {
            Map.Entry<Emp, String> me = iter.next();
            System.out.println(me.getKey() + ":" + me.getValue());
        }
    }
}


class Emp implements Comparable<Emp> {
    Integer eid;

    public Emp(Integer eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "" + this.eid;
    }

    @Override
    public int compareTo(Emp o) {
        return eid.compareTo(o.eid);
    }
}