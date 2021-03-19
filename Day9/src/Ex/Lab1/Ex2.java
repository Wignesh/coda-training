package Ex.Lab1;

public class Ex2 {
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        circle.calculateAre();
        circle.calculatePerimeter();
        System.out.println("Circle : " + circle.toString());

        Cuboid cuboid = new Cuboid(3);
        cuboid.calculateAre();
        cuboid.calculatePerimeter();
        cuboid.calculateSurface();
        cuboid.calculateVolume();
        System.out.println("Cuboid : " + cuboid.toString());

        Sphere sphere = new Sphere(4);
        sphere.calculateAre();
        sphere.calculatePerimeter();
        sphere.calculateSurface();
        sphere.calculateVolume();
        System.out.println("Sphere : " + sphere.toString());

        Square square = new Square(4);
        square.calculateAre();
        square.calculatePerimeter();
        square.calculateSurface();
        square.calculateVolume();
        System.out.println("Square : " + square.toString());

        Triangle triangle = new Triangle(1,2,3);
        triangle.calculateAre();
        triangle.calculatePerimeter();
        triangle.calculateSurface();
        triangle.calculateVolume();
        System.out.println("Triangle : " + triangle.toString());
    }
}

interface CalcArea {

    void calculateAre();

    void calculatePerimeter();

}

interface CalcVolume {
    void calculateVolume();

    void calculateSurface();

}

class Circle implements CalcArea, CalcVolume {

    double r, area, perimeter;

    Circle(double r) {
        this.r = r;
    }

    @Override
    public void calculateAre() {
        this.area = Math.PI * this.r * this.r;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * Math.PI * r;
    }

    @Override
    public void calculateVolume() {

    }

    @Override
    public void calculateSurface() {

    }

    @Override
    public String toString() {
        return String.format("Area : %f\nPerimeter : %f\n", this.area,this.perimeter);

    }
}

class Sphere implements CalcArea, CalcVolume {

    double r, area, perimeter, surface, volume;

    Sphere(double r) {
        this.r = r;
    }

    @Override
    public void calculateAre() {
        this.area = Math.PI * this.r * this.r;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * Math.PI * r;
    }

    @Override
    public void calculateVolume() {
        this.volume = 4 * Math.PI * r;
    }

    @Override
    public void calculateSurface() {
        this.surface = 4 / 3.0 * Math.PI * r;

    }

    @Override
    public String toString() {
        return String.format("Area : %f\nPerimeter : %f\nSurface : %f\n Volume : %f", this.area,this.perimeter,this.surface,this.volume);

    }

}

class Cuboid implements CalcArea, CalcVolume {

    double a, area, perimeter, surface, volume;

    Cuboid(double a) {
        this.a = a;
    }

    @Override
    public void calculateAre() {
        this.area = this.a * this.a;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 4 * this.a;
    }

    @Override
    public void calculateVolume() {
        this.volume = 6 * this.a * this.a;
    }

    @Override
    public void calculateSurface() {
        this.surface = this.a * this.a * this.a;

    }
    @Override
    public String toString() {
        return String.format("Area : %f\nPerimeter : %f\nSurface : %f\n Volume : %f", this.area,this.perimeter,this.surface,this.volume);

    }
}

class Triangle implements CalcArea, CalcVolume {

    double a, b, c, area, perimeter, surface, volume;


    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = b;
    }

    @Override
    public void calculateAre() {
        this.area = (a + b + c) / 2;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = a + b + c;
    }

    @Override
    public void calculateVolume() {
    }

    @Override
    public void calculateSurface() {

    }
    @Override
    public String toString() {
        return String.format("Area : %f\nPerimeter : %f", this.area,this.perimeter);

    }
}

class Square implements CalcArea, CalcVolume {
    double a, area, perimeter;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public void calculateAre() {
        this.area = this.a * this.a;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = 4 * this.a;
    }

    @Override
    public void calculateVolume() {

    }

    @Override
    public void calculateSurface() {

    }
    @Override
    public String toString() {
        return String.format("Area : %f\nPerimeter : %f\n", this.area,this.perimeter);

    }
}