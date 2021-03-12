//9. Create a class A. add public, private and protected member variable
//and methods. Create another class B which extends from A and add
//few members. Try to access a private ,public and protected members
//of a base class within a class B. observe the result

package Ex.Lab2;

public class Ex9 {
    public static void main(String[] args) {
        B b = new B();
        b.display();
    }
}

class A {
    private int aInt;
    public String aString;
    protected boolean aBoolean;
    char aChar;
}

class B extends A {
    byte aByte;
    long aLong;

    public void display() {
        System.out.println(aString);
        // can't access private  field
        // System.out.println(aInt);
        System.out.println(aBoolean);
        System.out.println(aChar);
        System.out.println(aByte);
        System.out.println(aLong);

    }
}