package Ex.Lab1;

public class Ex11 {
    public static void main(String[] args) {
        int[][] array = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}};

        for (int[] ints : array) {
            for (int j : ints) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }


    }
}
