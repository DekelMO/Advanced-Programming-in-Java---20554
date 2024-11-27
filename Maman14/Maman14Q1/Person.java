public class Person implements Comparable<Person>  {
	final int ID_MIN_VAL= 100000000;
	final int ID_MAX_VAL= 999999999;
	final int YEAR_MIN_VAL= 1900;
	final int YEAR_MAX_VAL= 2024;
	private int id = 000000000;
	private int yearOfBirth = YEAR_MIN_VAL;
	public Person(int id, int year) {
		if( year>=YEAR_MIN_VAL && year <=  YEAR_MAX_VAL)
			yearOfBirth = year;
		if( id>=ID_MIN_VAL && id <=  ID_MAX_VAL)
			this.id = id;
	}
	@Override
	public int compareTo(Person secPerson) {
		if (this.yearOfBirth < secPerson.yearOfBirth)
			return 1;
		else if (this.yearOfBirth > secPerson.yearOfBirth)
			return -1;
		else
			return 0;

	}
	public String toString() {
		return "Perosn ID:" + id + " and its year of birth " + yearOfBirth;
	}
}
