//9. Write a program to reverse elements in the Array

package Ex.Lab1;

import java.util.Arrays;

public class Ex9 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
