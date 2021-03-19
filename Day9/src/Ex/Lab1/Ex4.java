package Ex.Lab1;

public class Ex4 {
    public static void main(String[] args) {
        E e = new E();
        e.executeA(e);
        e.executeB(e);
        e.executeC(e);
        e.executeD(e);
    }
}

interface A {
    void helloA1();

    void helloA2();
}

interface B {
    void helloB1();

    void helloB2();
}

interface C {
    void helloC1();

    void helloC2();
}

interface D extends A, B, C {
    void helloD1();
}

class E implements D {


    @Override
    public void helloA1() {
        System.out.println("Hello A1");
    }

    @Override
    public void helloA2() {
        System.out.println("Hello A2");
    }

    @Override
    public void helloB1() {
        System.out.println("Hello B1");
    }

    @Override
    public void helloB2() {
        System.out.println("Hello B2");
    }

    @Override
    public void helloC1() {
        System.out.println("Hello C1");
    }

    @Override
    public void helloC2() {
        System.out.println("Hello C2");
    }

    @Override
    public void helloD1() {
        System.out.println("Hello D1");
    }

    void executeA(A a) {
        a.helloA1();

    }

    void executeB(B b) {
        b.helloB1();
    }

    void executeC(C c) {
        c.helloC1();
    }

    void executeD(D d) {
        d.helloD1();
    }
}