import java.util.ArrayList;

public class Manager {
    private ArrayList<Integer> array;
    private int sumCounter = 0;
    private int numOfSummtion;
    public Manager(ArrayList<Integer> array) {
        this.array = array;
        numOfSummtion = array.size()-1;
    }

    public synchronized int[] allocateNumbers() {
        while (array.size() < 2 && moreSums()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!moreSums())
        	return null;
        int temp[] = {array.remove(0), array.remove(0)};
        return temp;
    }

    public synchronized void addSum(int sum) {
        array.add(sum);
        sumCounter++;
        System.out.println(array);
        System.out.println(sumCounter);
        notifyAll();
        
    }

    public boolean moreSums() {
        return(sumCounter != numOfSummtion);
    }
    
    
}