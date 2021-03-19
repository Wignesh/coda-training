package Ex.Lab1;

import Ex.Lab1.Employee.Employee;
import Ex.Lab1.Employee.Sales.SalesManager;

public class Ex1 {
    public static void main(String[] args) throws Exception {
        Employee employee = new SalesManager("VGNESH", "J", "12345678");
        employee.setMonthlySalary(100);
        System.out.println(employee.toString());;
    }
}