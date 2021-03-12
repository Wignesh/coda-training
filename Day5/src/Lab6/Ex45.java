/**
 * 45. Design a class to represent a bank account including the following members.
 * Data members
 * Name of the depositor
 * Account number
 * Type of account
 * Balance amount in the account
 * Methods
 * To assign a initial values
 * To deposit an amount after checking balance
 * To display the name and balance
 * <p>
 * 46. Modify the above program (55) to incorporate a constructor to provide initial value and using this keyword.
 */
package Lab6;

public class Ex45 {
    public static void main(String[] args) {
        Bank myAccount = new Bank("VIGNESH J", AcType.SALARY);
        myAccount.display();
        System.out.println("Balance : " + myAccount.getAcBalance());
        myAccount.deposit(2500);
        myAccount.display();
    }
}

enum AcType {
    SAVING,
    SALARY,
    FD,
    RD,
    NRI
}

