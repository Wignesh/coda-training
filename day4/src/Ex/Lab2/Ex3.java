//3. Write a application to implement a Pay Roll System for an Organization

package Ex.Lab2;

import java.util.Date;

public class Ex3 {
    public static void main(String[] args) {
        Employee emp = new Employee(2, "VIGNESH J");
        emp.whoAmi();
    }
}

class Employee {
    protected Date doj;
    protected double hoursWorked;
    protected double pay;
    protected String name;

    Employee(double hoursWorked, String name) {
        this.doj = new Date();
        this.hoursWorked = hoursWorked;
        this.name = name;
    }

    public Employee() {

    }

    void whoAmi() {
        System.out.println("I'm a Worker");
    }
}

class SalesPerson extends Employee {
    double hourlyRate = 12.2;

    SalesPerson() {
        System.out.println("I'm a SalesPerson");
    }

    void whoAmi() {
        System.out.println("I'm a SalesPerson");
    }
}

class Worker extends Employee {
    double hourlyRate = 8.2;

    Worker() {
        System.out.println("I'm a Worker");
    }

    void whoAmi() {
        System.out.println("I'm a Worker");
    }
}

class SalesManager extends SalesPerson {
    double hourlyRate = 22.2;

    SalesManager() {
        System.out.println("I'm a SalesManager");
    }

    void whoAmi() {
        System.out.println("I'm a SalesManager");
    }
}

class SalesTerritoryManager extends SalesManager {
    double hourlyRate = 42.2;

    public SalesTerritoryManager() {
        System.out.println("I'm a SalesTerritoryManager");

    }

    void whoAmi() {
        System.out.println("I'm a SalesTerritoryManager");
    }
}