package ga.veee.day13.Lab;

import java.util.HashMap;
import java.util.Map;

public class Ex4 {
    public static void main(String[] args) {
        AccountManager am = new AccountManager();
        am.setBalance("VIGNESH J", 30000);
        System.out.println(am.getBalance("VIGNESH J"));
    }
}

class AccountManager {
    private Map<String, Integer> accountTotals = new HashMap<String, Integer>();
    private int retirementFund;

    public int getBalance(String accountName) {
        Integer total = (Integer) accountTotals.get(accountName);
        if (total == null) total = Integer.valueOf(0);
        return total.intValue();
    }

    public void setBalance(String accountName, int amount) {
        accountTotals.put(accountName, Integer.valueOf(amount));
    }
}