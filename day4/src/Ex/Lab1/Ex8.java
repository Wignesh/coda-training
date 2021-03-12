package Ex.Lab1;

import java.util.Arrays;

public class Ex8 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int el = 2;
        System.out.println(findElement(arr, el));

        // Much better
        System.out.println(Arrays.binarySearch(arr, el));
    }

    private static int findElement(int[] arr, int el) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el)
                return i;
        }
        return -1;
    }
}
