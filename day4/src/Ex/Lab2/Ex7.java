//7. Write a program to change state of object using the final reference variable.

package Ex.Lab2;

public class Ex7 {
    public static void main(String[] args) {

        final Sample2 obj1 = new Sample2();

        Sample2 obj2 = new Sample2();
        Sample2 obj3;

        obj2.setName("VIGNESH J");
        System.out.println(obj2.getName());

        obj3 = obj2;  //allowed

        System.out.println(obj3.getName());

        obj1.setName("J VIGNESH");
        System.out.println(obj1.getName());

        //but the value of the instance variables, the obj is referring to
        //can change

        obj1.setName("VIGNESH");
        System.out.println(obj1.getName());
    }
}

class Sample2 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}