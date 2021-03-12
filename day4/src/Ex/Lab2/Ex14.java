//14. Create a class Student consisting of name and rollno as
//members. Create a class exam inheriting student. It can have marks
//for 3 subjects. Create a class result inheriting exam contaning
//totalmark as member and a function to calculate the totalmark.

package Ex.Lab2;

public class Ex14 {
    public static void main(String[] args) {
        Result r = new Result("VIGNESH J", 9, 87, 97, 77);
        r.calc();
        r.display();
    }
}

class Student {
    String name;
    int rNo;
}

class Exam extends Student {
    int m1, m2, m3;
}

class Result extends Exam {
    int totalMark;

    Result(String name, int rNo, int m1, int m2, int m3) {
        this.name = name;
        this.rNo = rNo;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    void calc() {
        this.totalMark = this.m1 + this.m2 + this.m3;
    }

    void display() {
        System.out.println("Name: " + this.name + " RollNo: " + this.rNo + " Total Mark: " + this.totalMark);
    }

}