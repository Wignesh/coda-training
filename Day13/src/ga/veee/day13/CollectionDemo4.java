package ga.veee.day13;

import java.util.*;

public class CollectionDemo4 {
    public static void main(String[] args) {
//        Map<String,String > map = new HashMap<String,String>();

//        Map<String, String> map = new TreeMap<String, String>((o1, o2) -> {
//            return o2.compareTo(o1);
//        });

        Map<Emp,String> map=new TreeMap<Emp, String>((o1,o2)->{return o2.compareTo(o1);});
        map.put(new Emp(123), "hello");
        map.put(new Emp(124), "hai");
        map.put(new Emp(125), "world");

        System.out.println(map);

        Set<Map.Entry<Emp,String>> s=map.entrySet();
        Iterator<Map.Entry<Emp,String>> iter=s.iterator();
        while(iter.hasNext()) {
            Map.Entry<Emp,String> me=iter.next();
            System.out.println(me.getKey()+":"+me.getValue());
        }
    }
}


class Emp implements Comparable<Emp>{
    Integer eid;
    public Emp(Integer eid) {
        this.eid=eid;
    }
    @Override
    public String toString() {
        return ""+this.eid;
    }
    @Override
    public int compareTo(Emp o) {
        return eid.compareTo(o.eid);
    }
}