package Ex.Lab1;

public class Ex25 {
    public static void main(String[] args) {

    }
}

// protected not allowed outside
// protected class base {
class base {
    String Method() {
        return "Wow";
    }
}

class dervied {
    public void useD() {
        base z = new base();
        System.out.println("base says, " + z.Method());
    }
}