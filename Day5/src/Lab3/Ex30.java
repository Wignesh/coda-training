/**
 * 30. Write a program that uses a switch case to determine which season a particular month is in?
 */
package Lab3;

public class Ex30 {
    public static void main(String[] args) {
        System.out.println(getSeason(9));
    }

    public static String getSeason(int month) {
        return switch (month) {
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Fall";
            default -> "Winter";
        };

    }
}
