package Ex.Lab2;

public class Ex6 {
    public static void main(String[] args) throws Exception {
        Derived derived = new Derived();
    }
}
class Base {
    Base() throws Exception {
        throw new Exception();
    }
}
class Derived extends Base{
    Derived() throws Exception {
        try {
            System.out.println("Ex");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}