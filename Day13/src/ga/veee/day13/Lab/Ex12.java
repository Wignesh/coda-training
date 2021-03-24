package ga.veee.day13.Lab;

import java.util.LinkedHashSet;

public class Ex12 {
    public static void main(String[] args) {
        LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>();
        t.add(new Turtle(1));
        t.add(new Turtle(2));
        t.add(new Turtle(1));
        System.out.println(t.size());
        /**
         * [x] A. If fragment I is inserted, the output is 2
         * B. If fragment I is inserted, the output is 3
         * C. If fragment II is inserted, the output is 2
         * [x] D. If fragment II is inserted, the output is 3
         * E. If fragment I is inserted, compilation fails
         * F. If fragment II is inserted, compilation fails
         */
    }
}

class Turtle {
    int size;

    public Turtle(int s) {
        size = s;
    }

    public boolean equals(Object o) {
        return (this.size == ((Turtle) o).size);
    }

    // insert code here
//    public int hashCode() {
//        return size / 5;
//    }
}