// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary; // base salary per week

    // Constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary, int day, int month, int year) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, day, month, year);

        if (baseSalary < 0.0) {// validate baseSalary
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }

        this.baseSalary = baseSalary;
    }

    // Set base salary
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {// validate baseSalary
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    // Return base salary
    public double getBaseSalary() {
        return baseSalary;
    }

    // Calculate earnings; override method earnings in CommissionEmployee
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    // Return String representation of BasePlusCommissionEmployee object
    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
    }
}// end class BasePlusCommissionEmployee
