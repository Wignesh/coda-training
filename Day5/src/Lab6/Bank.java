package Lab6;

import java.util.Random;

class Bank {
    String name;
    String acNumber;
    AcType acType;
    double acBalance;

    Bank(String name, AcType acType) {
        this.name = name;
        this.acType = acType;
        this.acNumber = String.format("%04d", new Random().nextInt(10000));
        this.acBalance = 0.0D;
    }

    public double deposit(double amount) {
        this.acBalance += amount;
        return this.acBalance;
    }

    public double getAcBalance() {
        return this.acBalance;
    }

    public void display() {
        System.out.println("Account Holder Name : " + this.name);
        System.out.println("Account Number : " + this.acNumber);
        System.out.println("Account Type : " + this.acType);
        System.out.println("Account Balance : " + this.acBalance);
    }
}

