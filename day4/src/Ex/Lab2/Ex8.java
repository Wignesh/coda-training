//8. write a program to create Singleton Class
// (Program should not allow more than one instance at a time)

package Ex.Lab2;

public class Ex8 {
    public static void main(String[] args) {
        SingletonClass sc;
        sc = SingletonClass.getInstance();

        sc.sayHello();
        // can't create because it's private
        //SingletonClass stc = new SingletonClass();
    }
}

class SingletonClass {
    private static SingletonClass scObject;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {

        if (scObject == null) {
            scObject = new SingletonClass();
        }
        return scObject;
    }

    public void sayHello() {
        System.out.println("Hello ✋");
    }
}