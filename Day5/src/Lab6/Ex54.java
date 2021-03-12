/**
 * 54. Write a simple interface program to print an integer value using access implementation through interface references?
 */
package Lab6;

public class Ex54 {
    public static void main(String[] args) {
        InterFaceImpl inf = new InterFaceImpl();
        inf.printInt(10);
    }
}

interface InterFace {
    public void printInt(int x);
}

class InterFaceImpl implements InterFace {

    public void printInt(int x) {
        System.out.println("X : " + x);
    }
}