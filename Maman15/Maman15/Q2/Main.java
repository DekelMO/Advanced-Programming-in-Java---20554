import java.util.Random;

public class Main {
	public static void main( String[] args) {
		final int NUM_OF_FLIGHTS = 10;
		Airport madagascarAirport = new Airport(3,"Madagascar");
		Airport kazakhstanAirport = new Airport(3,"Kazakhstan");
		Flight flights[] = new Flight[NUM_OF_FLIGHTS];
		Random r = new Random();
		for(int i = 0 ; i < NUM_OF_FLIGHTS ; i++) {
			if(r.nextBoolean()) {
				flights[i] = new Flight(i+1,madagascarAirport,kazakhstanAirport);
			}
			else {
				flights[i] = new Flight(i+1,kazakhstanAirport,madagascarAirport);
		}}
		for(int i = 0 ; i < NUM_OF_FLIGHTS ; i++) {
			flights[i].start();
		}




	}
}
