//16. Write a program to search a given element is present or not? If
//present, display the location and how many times it occurs

package Ex.Lab1;

public class Ex16 {
    public static void main(String[] args) {
        int[] arr = {1, 11, 8, 111, 1111};

        int number = 8;

        checkElement(arr, number);
    }

    private static void checkElement(int[] arr, int number) {

        boolean isPresent = false;
        int count = 0;

        for (int element : arr) {
            if (element == number) {
                isPresent = true;
                count++;
            }
        }

        if (isPresent) {
            System.out.printf("Number %d is present %d times", number, count);
        } else {
            System.out.printf("Number %d not found", number);
        }

    }
}
