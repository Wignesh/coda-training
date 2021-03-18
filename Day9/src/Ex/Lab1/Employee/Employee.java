package Ex.Lab1.Employee;

public abstract class Employee {
    public Employee(String firstName, String lastName, String uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
    }

    private String lastName;
    private String uuid;
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override


    public String toString() {
        return String.format("%s %s\nUUID: %s", getFirstName(), getLastName(), getUuid());
    }

    public abstract double earnings();
}
