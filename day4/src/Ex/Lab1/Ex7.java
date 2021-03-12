package Ex.Lab1;

import java.util.Arrays;

public class Ex7 {
    public static void main(String[] args) {
        int[] arr = {7, 4, 1, 6};
        System.out.println(Arrays.toString(arr));

        sortAsc(arr);

        System.out.println(Arrays.toString(arr));

        sortDesc(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void sortDesc(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void sortAsc(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
