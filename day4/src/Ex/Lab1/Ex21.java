//21. Write a program using Switch–case to print number of days in
//a month. For the month of February check for leap year and
//calculate.

package Ex.Lab1;

public class Ex21 {

    public static void main(String[] args) {
        numOfDays(2, 2020);
    }

    private static void numOfDays(int month, int year) {
        int nodays = 0;
        String monthName = "";

        switch (month) {
            case 1 -> {
                monthName = "January";
                nodays = 31;
            }
            case 2 -> {
                monthName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    nodays = 29;
                } else {
                    nodays = 28;
                }
            }
            case 3 -> {
                monthName = "March";
                nodays = 31;
            }
            case 4 -> {
                monthName = "April";
                nodays = 30;
            }
            case 5 -> {
                monthName = "May";
                nodays = 31;
            }
            case 6 -> {
                monthName = "June";
                nodays = 30;
            }
            case 7 -> {
                monthName = "July";
                nodays = 31;
            }
            case 8 -> {
                monthName = "August";
                nodays = 31;
            }
            case 9 -> {
                monthName = "September";
                nodays = 30;
            }
            case 10 -> {
                monthName = "October";
                nodays = 31;
            }
            case 11 -> {
                monthName = "November";
                nodays = 30;
            }
            case 12 -> {
                monthName = "December";
                nodays = 31;
            }
        }
        System.out.println(monthName + " " + year + " has " + nodays + "days");
    }
}
