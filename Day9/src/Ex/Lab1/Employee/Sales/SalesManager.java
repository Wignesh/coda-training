package Ex.Lab1.Employee.Sales;

import Ex.Lab1.Employee.Employee;

public class SalesManager extends Employee {

    public SalesManager(String firstName, String lastName, String uuid) {
        super(firstName, lastName, uuid);
    }

    @Override
    public double earnings() {
        return getMonthlySalary();
    }


    @Override
    public String toString() {
        return String.format("Salaried employee: %s\n%s: $%,.2f", super.toString(), "Monthly salary", getMonthlySalary());
    }

}
