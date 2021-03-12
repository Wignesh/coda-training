//10.Write a program to display number matrix as follows using Two Dimensional
//        Rectangular Array.


package Ex.Lab1;

public class Ex10 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        for (int[] ints : array) {
            for (int j : ints) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
