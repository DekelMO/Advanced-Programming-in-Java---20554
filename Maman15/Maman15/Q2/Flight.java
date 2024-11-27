import java.util.Random;

public class Flight extends Thread {
	private final int TIME = 3 * 1000;
	private final int MIN_TIME = 2;
	private int flightNum;
	private Airport departPort;
	private Airport landPort;
	private int runwayNum;
	private Random r = new Random();

	public Flight(int flightNum, Airport departPort,Airport landPort) {
		this.flightNum = flightNum;
		this.departPort=departPort;
		this.landPort = landPort;
	}

	public void run() {
		super.run();
		runwayNum = departPort.depart(flightNum);
		//waitRandomTime();
		departPort.freeRunway(flightNum, runwayNum);
		//waitRandomTime();
		runwayNum = landPort.land(flightNum);
		//waitRandomTime();
		landPort.freeRunway(flightNum, runwayNum);
		
	}
	private void waitRandomTime() {
		try {
			sleep(r.nextInt(TIME)+MIN_TIME);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
