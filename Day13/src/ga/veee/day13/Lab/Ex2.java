package ga.veee.day13.Lab;

/**
 * 2. Which statements are true about comparing two instances of the same class, given that the equals() and hashCode()
 * methods have been properly overridden? (Choose all that apply.)
 * A. If the equals() method returns true, the hashCode() comparison == might return false
 * B. If the equals() method returns false, the hashCode() comparison == might return true
 * C. If the hashCode() comparison == returns true, the equals() method must return true
 * D. If the hashCode() comparison == returns true, the equals() method might return true
 * E. If the hashCode() comparison != returns true, the equals() method might return true
 * ANS -> C,D
 */
public class Ex2 {
    public static void main(String[] args) {
        Em e1 = new Em();
        Em e2 = new Em();

        //A
        System.out.println(e1.hashCode() == e2.hashCode());
        System.out.println(e1.equals(e2));

        //B
        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode() == e2.hashCode());

        //C

    }
}

class Em {

}