import java.util.ArrayList;

public class Q1 {
	public static void main(String[] args) {
		Employee worker;
		ArrayList<Employee> employees = new ArrayList<>();
		try {
			// Create instances of different employee types
			employees.add(new SalariedEmployee("Maple", "TheCat", "205804925" , 3534.222, 19,  11, 1994));
			employees.add(new SalariedEmployee("Maple2", "TheCat", "205804925" , 355534.222, 19,  4, 1991));
			employees.add(new HourlyEmployee("tome", "moens" , "12345", 33.26, 60 , 8, 11, 1996));
			employees.add(new HourlyEmployee("tome2", "moens" , "12345", 33.26, 60 , 8, 4, 1996));
			employees.add(new CommissionEmployee("Eli", "copter", "66777777", 1000000, 0.04, 4, 7, 2004));
			employees.add(new CommissionEmployee("Eli2", "Copter", "66777777", 1000000, 0.04, 4, 4, 2004));
			employees.add(new BasePlusCommissionEmployee("Micha", "Mor", "339664442" , 1000000, 0.04, 777, 1, 1, 1925));
			employees.add(new BasePlusCommissionEmployee("Micha2", "Mor", "339664442" , 1000000, 0.04, 777, 1, 4, 1925));
			employees.add(new PieceWorker("abu", "gadro", "111111", 13.41, 700 ,11, 11, 1992));
			employees.add(new PieceWorker("abu", "gadro", "111111", 13.41323, 700 ,11, 11, 1992)); 
			employees.add(new PieceWorker("abu2", "gadro", "111111", 13.41323, 700 ,11, 4, 1992)); 
		}
		 // Handle exceptions related to invalid employee data
		catch (IllegalArgumentException e) {
			System.out.println("One or more of the employees buildlers recived illegal argument.\nRemember:\nWeekly salary must be >= 0.\n"
					+ "Pieces created must be >= 0, price per piece must be >= 0.0\nHourly wage must be >= 0.0, Hours worked must be >= 0.0 and <= 168.0\n"
					+ "Commission rate must be > 0.0 and < 1.0, Gross sales must be >= 0.0\nBase salary must be >= 0.0\n"
					+ "All dates need to be correct ");
		}
		// Prints all the employees' details and adds a birthday greeting for employees who have a birthday this month
		for(int i = 0; i < employees.size(); i++) {
			worker = employees.get(i);
			if(worker.getBDay().isBdayMonth()) {
				System.out.println("Happt Birth Day " + worker.getFirstName() +" "+ worker.getLastName() + ",to show our company appreciation 200$ were added to your salary" );	
			}
			System.out.println(employees.get(i) + "\n");
		}
	}

}

