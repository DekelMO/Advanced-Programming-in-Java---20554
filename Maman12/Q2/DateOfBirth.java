
import java.util.Calendar;

public class DateOfBirth {
	private int day,month,year;

	public DateOfBirth(int day, int month, int year) {
		if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900) {
			throw new IllegalArgumentException("Invalid date of birth");
		}
		this.day = day;
		this.month = month;
		this.year = year;
	}
	// Return month
	public double getMonth() {
		return month;
	}
	// Checks if this month is the current month
	public boolean isBdayMonth() {
		Calendar currentTime = Calendar.getInstance();
		int currentMonth = currentTime.get(Calendar.MONTH) + 1;//Add 1 to the month (to make it human-readable)
		if (currentMonth == getMonth()) {
			return true;
		}
		else
			return false;
	}
	// Return String representation of DateOfBirth object
	@Override
	public String toString() {
		return String.format("%d/%d/%d", day, month, year);
	}
}
