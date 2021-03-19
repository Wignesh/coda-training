package Ex.Lab1;

import Ex.Lab1.Ex6.Ex6Pro;

public class Ex6Access extends Ex6Pro {
    public static void main(String[] args) {
        sayHello();
    }
}

class InvalidAccess {
    void execute() {
//        sayHello();
    }
}