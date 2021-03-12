/**
 * 52. Design a package to display the name and account balance using array of object?
 */
package Lab6;

public class Ex52 {
    public static void main(String[] args) {
        Bank[] users = new Bank[5];
        for (int i = 0; i < 5; i++) {
            users[i] = new Bank("USER-" + i, AcType.SALARY);
            users[i].deposit(100 - i);
            users[i].display();
        }
    }

}
