// Fig. 10.5: SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee
public class SalariedEmployee extends Employee {
    private double weeklySalary;

    // Constructor
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary,int day, int month, int year) {
        super(firstName, lastName, socialSecurityNumber, day, month, year);
        
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }
        
        this.weeklySalary = weeklySalary;
    }

    // Set salary
    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }
        this.weeklySalary = weeklySalary;
    }

    // Return salary
    public double getWeeklySalary() {
        return weeklySalary;
    }

    // Calculate earnings; override abstract method earnings in Employee
    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    // Return String representation of SalariedEmployee object
    @Override
    public String toString() {
        return String.format("Salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary(wihtout bonus):", getWeeklySalary(), earnings());
    }
}// end class SalariedEmployee
