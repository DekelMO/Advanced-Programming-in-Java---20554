// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee
public class HourlyEmployee extends Employee {
    private double wage; // wage per hour
    private double hours; // hours worked for the week

    // Constructor
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours, int day, int month, int year) {
        super(firstName, lastName, socialSecurityNumber, day, month, year);

        if (wage < 0.0) {// validate wage
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }

        if (hours < 0.0 || hours > 168.0) {// validate hours
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }

        this.wage = wage;
        this.hours = hours;
    }

    // Set wage
    public void setWage(double wage) {
        if (wage < 0.0) {// validate wage
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }
        this.wage = wage;
    }

    // Return wage
    public double getWage() {
        return wage;
    }

    // Set hours worked
    public void setHours(double hours) {
        if (hours < 0.0 || hours > 168.0) {// validate hours
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
        this.hours = hours;
    }

    // Return hours worked
    public double getHours() {
        return hours;
    }

    // Calculate earnings; override abstract method earnings in Employee
    @Override
    public double earnings() {
    	double salary;
        if (getHours() <= 40) {
        	salary =  getWage() * getHours(); // No overtime
        } else {
        	salary = 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        }
        return salary;
    }

    // Return String representation of HourlyEmployee object
    @Override
    public String toString() {
        return String.format("Hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
    }
}// end class HourlyEmployee
