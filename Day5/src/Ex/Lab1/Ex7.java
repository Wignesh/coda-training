//7.Write a Java program to print the following string in a specific format ?
//Twinkle, twinkle, little star,
//      How I wonder what you are!
//              Up above the world so high,
//              Like a diamond in the sky.
//Twinkle, twinkle, little star,
//      How I wonder what you are
package Ex.Lab1;

public class Ex7 {
    public static void main(String[] args) {
        print("Twinkle, twinkle, little star,", 0);
        print("How I wonder what you are!", 2);
        print("Up above the world so high,", 4);
        print("Like a diamond in the sky.", 4);
        print("Twinkle, twinkle, little star,", 0);
        print("How I wonder what you are!", 2);
    }

    public static void print(String s, int indent) {
        System.out.println("\t".repeat(indent) + s);
    }
}