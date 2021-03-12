//4.Write a Java program to count the letters, spaces, numbers and other characters of an input string ?
package Ex.Lab1;

public class Ex4 {
    public static void main(String[] args) {
        String s = "4.Write a Java program to count the letters, spaces, numbers and other characters of an input string ?";
        int[] counts = count(s);
        System.out.println("Letters : " + counts[0]);
        System.out.println("Spaces : " + counts[1]);
        System.out.println("Digits : " + counts[2]);
        System.out.println("Others : " + counts[2]);
    }

    private static int[] count(String s) {
        char[] chars = s.toCharArray();
        int letters = 0, spaces = 0, digits = 0, others = 0;
        for (char c : chars) {
            if (Character.isLetter(c))
                letters++;
            else if (Character.isSpaceChar(c))
                spaces++;
            else if (Character.isDigit(c))
                digits++;
            else
                others++;
        }
        return new int[]{letters, spaces, digits, others};
    }
}
