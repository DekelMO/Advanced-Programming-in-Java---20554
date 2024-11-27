// Fig. 10.4: Employee.java
// Employee abstract superclass
public abstract class Employee {
	private final DateOfBirth bDay;
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    // Constructor
    public Employee(String firstName, String lastName, String socialSecurityNumber, int day, int month, int year) {
        this.bDay = new DateOfBirth(day,month,year);
    	this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }
 // Return bDay
    public DateOfBirth getBDay() {
        return bDay;
    }
    // Return first name
    public String getFirstName() {
        return firstName;
    }

    // Return last name
    public String getLastName() {
        return lastName;
    }

    // Return social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // Return String representation of Employee object
    @Override
    public String toString() {
    	return String.format("%s %s%nDate of Birth: %s%nSocial Security Number: %s%nSalary(include bonus if its birthday month): $%,.2f", getFirstName(), getLastName(), 
    			bDay, getSocialSecurityNumber(),salaryWithBonus(earnings()));
    }

    public double salaryWithBonus(double earnings) {
    	if(bDay.isBdayMonth()) {
    		earnings +=200;
    	}
    	return earnings;
    }
    // Abstract method to be overridden by concrete subclasses
    public abstract double earnings(); // No implementation here
}// end abstract class Employee