package Ex.Lab2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 1.Create a class with a method throwing an object of class IOException.
 * Neither catch this object nor use throws clause. Test and see the result
 */
public class Ex1 {
    public static void main(String[] args) throws Exception {
        catchException();
        throwException();
    }

    static void throwException() throws IOException {
        System.out.println("Before Exception");
        FileInputStream in = new FileInputStream("vignesh.java");
        System.out.println("After Exception");
    }

    static void catchException() {
        System.out.println("Before Exception");
        try {
            FileInputStream in = new FileInputStream("vignesh.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("After Exception");
    }
}

