/**
 * 49. Write a simple program find the volume of Box using method calls?
 */
package Lab6;

public class Ex49 {
    public static void main(String[] args) {
        Box box = new Box(4, 6, 3);
        System.out.println(box.getVolume());
    }
}

class Box {
    double width, length, height;

    Box(double w, double l, double h) {
        this.width = w;
        this.length = l;
        this.height = h;
    }

    public double getVolume() {
        return this.width * this.height * this.length;
    }
}