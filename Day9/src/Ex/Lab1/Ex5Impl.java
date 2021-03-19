package Ex.Lab1;

import Ex.Lab1.Ex5.Ex5Int;

public class Ex5Impl implements Ex5Int {
    public static void main(String[] args) {
        Ex5Impl imp = new Ex5Impl();
        imp.sayHello();
        imp.sayHello("VIGNESH");
        imp.sayHello("VIGNESH", 12);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void sayHello(String s) {
        System.out.println("Hello " + s);
    }

    @Override
    public void sayHello(String s, int i) {
        System.out.println("Hello " + s + " " + i);
    }
}
