package ga.veee.day9;

public class ExceptionDemo3 {
    public static void main(String[] args) throws CustomException {
        throw new CustomException();
    }
}

class CustomException extends Exception {

}