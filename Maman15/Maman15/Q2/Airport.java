import java.util.ArrayList;

public class Airport {
	private int empty;
	private int tempRunway;
	private boolean runways[];
	private ArrayList<Integer> waitingList = new ArrayList<>();
	private String name;
	

	public Airport(int numOfRunways, String name) {
		empty = numOfRunways;
		runways = new boolean[numOfRunways];
		this.name = name;
	}


	public synchronized int depart(int flightNum) {
		System.out.println("Flight #" +flightNum +" requested to depart from the port of " + name);
		tempRunway= availableRunway( flightNum);
		System.out.println("Flight #" +flightNum +" is departing from the port of " + name + ", runway #" + tempRunway);
		return tempRunway;
	}

	public synchronized int land(int flightNum) {
		System.out.println("Flight #" +flightNum +" requested to land in the port of " + name);
		tempRunway= availableRunway( flightNum);
		System.out.println("Flight #" +flightNum +" is landing in the port of " + name + ", runway #" + tempRunway);
		return tempRunway;
	}

	public synchronized void freeRunway(int flightNum, int runway) {
		runways[runway] = false; 
		empty++;
		notify();
	}

	private synchronized int availableRunway(int flightNum) {
		waitingList.add(flightNum);
		System.out.println("waiting list to the port of " + name +":" + waitingList);
		while(empty == 0 || flightNum != waitingList.get(0)) {
			try {
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		waitingList.remove(0);
		for(int i =0; i < runways.length; i++) {
			if(!runways[i]) {
				empty--;
				runways[i] = true;
				return i;
			}
		}
		return -1;
	}
}
