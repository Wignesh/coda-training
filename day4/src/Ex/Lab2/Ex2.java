//2. Write a program to add two complex number using this reference

package Ex.Lab2;

public class Ex2 {
    public static void main(String[] args) {
        Complex c1 = new Complex(5.5, 4), c2 = new Complex(1.2, 3.5), sum;
        sum = Complex.sum(c1, c2);
        System.out.print(sum.real + " + " + sum.img + "i");
    }
}

class Complex {
    double real, img;

    Complex(double r, double i) {
        this.real = r;
        this.img = i;
    }

    public static Complex sum(Complex c1, Complex c2) {
        Complex c = new Complex(0, 0);
        c.real = c1.real + c2.real;
        c.img = c1.img + c2.img;
        return c;
    }
}