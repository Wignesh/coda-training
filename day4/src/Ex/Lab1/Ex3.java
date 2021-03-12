package Ex.Lab1;

public class Ex3 {
    public static void main(String[] args) {
        //initialization
        int aInt;
        aInt = 1;
        int bInt = 2;

        short aShort;
        aShort = 1;
        short bShort = 2;

        long aLong;
        aLong = 9223372036854775807L;
        long bLong = 9223372036854775807L;

        float aFloat;
        aFloat = 3.33333333F;
        float bFloat = 3.33333333F;

        double aDouble;
        aDouble = 3.3333333333333333333333333333333333;
        double bDouble = 3.3333333333333333333333333333333333;

        boolean aBoolean;
        aBoolean = true;
        boolean bBoolean = false;

        char aChar;
        aChar = 'A';
        char bChar = 'B';

        // implicit type casting
        aInt = aShort;
        aDouble = aLong;
        aLong = aInt;
        aFloat = aLong;

        // explicit type casting

        aInt = (int) aChar;
        aLong = (long)  aDouble;
        aDouble = (float) aLong;
    }
}
