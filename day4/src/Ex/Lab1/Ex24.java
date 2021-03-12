//24. Write a simple Java class for quadratic functions of the form
//f(x) = ax2
// + bx + c.
//It contain the following elements:
// fields for values a, b, and c,
// A(int a,int b,intc)
// new Abc(2,3,4)
// a constructor with no parameters (setting a, b, and c to 1),
// a constructor with 3 parameters, to specify a, b, and c,
// three extractors that return the values of a, b, and c, respectively,
// a modifier that requires three parameters, one each to give new
//values to a, b, and c,
// a compute method that takes a parameter x and that returns the
//value f(x) for the given values of a, b, and c, and a main method
//that exercises each of the methods.

package Ex.Lab1;

/**
 * Spoiler : I don't know Quadratic equation
 */
public class Ex24 {
    public static void main(String[] args) {
        //Quadratic qu = new Quadratic();
        Quadratic qu = new Quadratic(1, 2, 3);
        System.out.println(qu.getA());
        System.out.println(qu.getB());
        System.out.println(qu.getC());
        System.out.println(qu.compute(2));
        qu.setABC(3, 2, 1);
        System.out.println(qu.getA());
        System.out.println(qu.getB());
        System.out.println(qu.getC());
        System.out.println(qu.compute(2));
    }
}

class Quadratic {

    int a, b, c;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void setABC(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Quadratic() {
        this.a = this.b = this.c = 1;
    }

    Quadratic(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int compute(int x) {
        return ((this.a * x) * 2) + (b * x) + c;
    }

}