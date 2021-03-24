package ga.veee.day13;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<String>();
        Set<Student> set = new TreeSet<Student>(((o1, o2) -> {
            return o2.compareTo(o1);
        }));

        set.add(new Student(430));
        set.add(new Student(350));
        set.add(new Student(400));
        set.add(new Student(340));

        System.out.println(set);
    }
}

class Student implements Comparable<Student> {
    Integer mark;

    Student(Integer mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student o) {
        return o.mark.compareTo(mark);
    }

    @Override
    public String toString() {
        return "" + mark;
    }
}