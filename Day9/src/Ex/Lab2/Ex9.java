package Ex.Lab2;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, c, total = 0;
        System.out.println("Enter no of students : ");
        n = scan.nextInt();
        c = n;
        while (n-- != 0) {
            total += getNum(scan);
        }
        System.out.println("Average : " + total / c);

    }

    public static int getNum(Scanner s) {
        int num;
        try {
            System.out.print("> ");
            num = Integer.parseInt(s.next());
            if (num < 0)
                throw new NegativeException("Number should be > 0");
            else if (num > 100)
                throw new NumRangeException("Number must be between 0 - 100");
        } catch (NumberFormatException e) {
            System.out.println("Re enter a valid number");
            return getNum(s);
        } catch (NumberExceptions nue) {
            nue.handle(new HandlerExceptionImpl());
            return getNum(s);
        }
        return num;
    }
}

abstract class NumberExceptions extends Exception {
    public abstract void handle(HandlerException handlerException);
}

interface HandlerException {
    void handle(NegativeException ne);

    void handle(NumRangeException nre);

}

class HandlerExceptionImpl implements HandlerException {

    @Override
    public void handle(NegativeException ne) {
        System.out.println("Re enter a valid number \n Number should be > 0");
    }

    @Override
    public void handle(NumRangeException nre) {
        System.out.println("Re enter a valid number \n Number must be between 0 - 100");
    }
}

class NegativeException extends NumberExceptions {
    String msg;

    public NegativeException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }

    @Override
    public void handle(HandlerException handlerException) {
        handlerException.handle(this);
    }
}

class NumRangeException extends NumberExceptions {
    String msg;

    public NumRangeException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }

    @Override
    public void handle(HandlerException handlerException) {
        handlerException.handle(this);
    }
}