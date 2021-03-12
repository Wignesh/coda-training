//20. Write a program to find the largest element in each row of a
//two dimensional array

package Ex.Lab1;

public class Ex20 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] out : array) {
            int large = out[0];
            for (int num : out) {
                if (large < num)
                    large = num;
            }
            System.out.println("Large number : " + large);
        }
    }
}
