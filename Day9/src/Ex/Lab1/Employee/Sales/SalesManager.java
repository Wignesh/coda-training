package Ex.Lab1.Employee.Sales;

import Ex.Lab1.Employee.Employee;

public class SalesManager extends Employee {
    private double monthlySalary;

    public SalesManager(String firstName, String lastName, String uuid) {
        super(firstName, lastName, uuid);
    }

    @Override
    public double earnings() {
        return getMonthlySalary();
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) throws Exception {
        if (monthlySalary > 0.0)
            this.monthlySalary = monthlySalary;
        else
            throw new Exception("Monthly salary must be >= 0.0");

    }

    @Override
    public String toString() {
        return String.format("Salaried employee: %s\n%s: $%,.2f", super.toString(), "Monthly salary", getMonthlySalary());
    }

}
