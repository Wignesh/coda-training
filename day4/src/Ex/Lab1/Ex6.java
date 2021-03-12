package Ex.Lab1;

import java.util.Arrays;

public class Ex6 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Array length : " + arr.length);
        arr = Arrays.copyOf(arr,10);
        System.out.println("Array length : " + arr.length);
    }
}
