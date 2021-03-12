//12. Create an inheritance hierarchy of Wipro: WiproTechnologies,
//Wipro Infotech , Wipro BPO etc. In the base class, provide
//methods that are common to all Wipro, and override these in the
//derived classes to perform different behaviors depending on the
//specific type of Wipro. Create an array of Wipro, fill it with different
//specific types of Wipro, and call your base-class methods to see what
//happens.

package Ex.Lab2;

public class Ex12 {
    public static void main(String[] args) {
        Wipro[] objs = {new Wipro(), new WiproTechnologies(), new WiproInfotech(), new WiproBPO()};
        for (Wipro obj : objs) {
            // all the methods are override based of class
            obj.whoWeAre();
        }
    }
}

class Wipro {
    void whoWeAre() {
        System.out.println("We're Wipro");
    }
}

class WiproTechnologies extends Wipro {
    void whoWeAre() {
        System.out.println("We're WiproTechnologies");
    }
}

class WiproInfotech extends Wipro {
    void whoWeAre() {
        System.out.println("We're WiproInfotech");
    }
}

class WiproBPO extends Wipro {
    void whoWeAre() {
        System.out.println("We're WiproBPO");
    }
}