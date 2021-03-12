//27. Create a program that calculates how much a $14,000
//investment would be worth if it increased in value by 40% during the
//first year, lost $1,500 in value the second year, and increased 12% in
//the third year.

package Ex.Lab1;

public class Ex27 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.invest(14000);
        bank.plPercent(40);
        bank.plValue(-1500);
        bank.plPercent(12);
        System.out.println(bank.getAmount());
    }
}

class Bank {
    int amount;

    public void invest(int amount) {
        this.amount = amount;
    }

    public void plValue(int value) {
        this.amount += value;
    }

    public void plPercent(int value) {
        this.amount += (this.amount * value) / 100;
    }

    public int getAmount() {
        return amount;
    }
}