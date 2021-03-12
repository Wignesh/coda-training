/**
 * 51. Write a program to print the integer value using method overriding and super keyword?
 */
package Lab6;

public class Ex51 {
    public static void main(String[] args) {
        C c = new C();
        c.Print(2);
    }
}


class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }

    public B(int i) {
        System.out.println("B : " + i);
    }

    protected void Print(int i) {
        System.out.println("B : " + i);
    }
}

class C extends B {

    public C() {
        super(9);
    }

    @Override
    public void Print(int i) {
        super.Print(10);
    }
}