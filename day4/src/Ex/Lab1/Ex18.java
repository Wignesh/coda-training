//18. write a program to convert number into words
// Example: 125 as one two five (or one hundred twenty five)

package Ex.Lab1;

public class Ex18 {
    public static final String[] place = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String numbToWord(final int n) {
        if (n < 0) {
            return "Minus " + numbToWord(-n);
        }

        if (n < 20) {
            return place[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + place[n % 10];
        }

        if (n < 1000) {
            return place[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + numbToWord(n % 100);
        }

        if (n < 100000) {
            return numbToWord(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + numbToWord(n % 1000);
        }

        if (n < 10000000) {
            return numbToWord(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + numbToWord(n % 100000);
        }

        return numbToWord(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + numbToWord(n % 10000000);
    }

    public static void main(String[] args) {
        System.out.println(numbToWord(1000));
    }
}
