//5. Write a program to calculate the number of object created at any point using
//user defined class

package Ex.Lab2;

public class Ex5 {
    public static void main(String[] args) {
        Sample t1 = new Sample();
        Sample t2 = new Sample();
        Sample t3 = new Sample();
        System.out.println(Sample.num);
    }
}

class Sample {

    static int num = 0;

    public Sample() {
        num += 1;
    }
}
