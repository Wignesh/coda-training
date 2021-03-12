//19. Write a program to reverse the elements of each row in a two
//dimensional array

package Ex.Lab1;

import java.util.Arrays;

public class Ex19 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {3, 2, 1}, {2, 1, 3}};
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array[j].length / 2; i++) {
                int temp = array[j][i];
                array[j][i] = array[j][array[j].length - i - 1];
                array[j][array[j].length - i - 1] = temp;
            }
        }
        System.out.println(Arrays.deepToString(array));
    }
}
