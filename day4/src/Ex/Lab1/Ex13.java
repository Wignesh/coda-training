//13.Write a Program to calculate result of students.(take no of student as
//rows and marks as columns of two Dimensional Array)

package Ex.Lab1;

public class Ex13 {
    public static void main(String[] args) {
        int[][] students = {{40, 69, 80, 75, 90}, {35, 45, 100, 47, 90}, {56, 67, 77, 87, 97}};
        for (int i = 0; i < students.length; i++) {
            int sum = 0;
            for (int mark : students[i]) {
                sum += mark;
            }
            System.out.println("Student " + (i + 1) + " = " + sum);
        }
    }
}