/**
 * 50. Write Example program – Inheritance and multilevel inheritance?
 */
package Lab6;

public class Ex50 {
    public static void main(String[] args) {
        iPhoneX myIphone = new iPhoneX();
        myIphone.mobileType();
        myIphone.brand();
        myIphone.iOSVersion();
    }
}

class Mobile {
    Mobile() {
        System.out.println("I'm a mobile");
    }

    public void mobileType() {
        System.out.println("Mobile Type: SmartPhone");
    }
}

class Apple extends Mobile {
    Apple() {
        System.out.println("I'm a Apple mobile");
    }

    public void brand() {
        System.out.println("Brand Apple");
    }

    public void iOSVersion() {
        System.out.println("Latest: 13.0");
    }
}

class iPhoneX extends Apple {
    iPhoneX() {
        System.out.println("I'm Apple iPhoneX");
    }

    public void iOSVersion() {
        System.out.println("I'm: 12 .0");
    }
}