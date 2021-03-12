//1. Write a program to prove that Primitive data types are passed by value and
//object and arrays are passed by reference.

package Ex.Lab2;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        int x = 2;
        int[] array = {3, 2, 1};
        System.out.println("Before change X : " + x);
        //passes value not reference
        changeX(x);
        System.out.println("After change (Unchanged) X : " + x);

        System.out.println("Before Sort Array : " + Arrays.toString(array));
        // passes reference
        sortArray(array);
        System.out.println("After Sort Array : " + Arrays.toString(array));
    }

    // get reference not value
    private static void sortArray(int[] array) {
        // modify referenced data
        Arrays.sort(array);
    }

    //  passed by value
    private static void changeX(int x) {
        // can't change local x in main
        // change x in local changeX
        x = 4;
    }
}
