package Ex.Lab2;

public class Ex4 {
    public static void main(String[] args) {
        try {
            throw new Exception911("Custom Exception");
        } catch (Exception911 e){
            e.catchException();
        }
    }
}

class Exception911 extends Exception {

    String msg;

    public Exception911(String msg) {
        this.msg = msg;
    }

    public void catchException() {
        System.out.println(this.msg);
    }
}
