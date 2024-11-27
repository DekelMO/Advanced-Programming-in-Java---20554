import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main( String[] args) {
		int sizeOfArray;
		int numOfThreads;
		Worker worker[] ;
		ArrayList<Integer> array = new ArrayList<Integer>();;
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		System.out.println("Please enter the size of the array");
		sizeOfArray = scan.nextInt();
		System.out.println("Please enter the numer of threads");
		numOfThreads = scan.nextInt();
		
		for(int i = 0 ; i < sizeOfArray ; i++) {
			array.add(random.nextInt(100) + 1);
		}
		System.out.println("Array: " + array);
		Manager m = new Manager(array);
		worker = new Worker[numOfThreads];
		for(int i = 0; i < numOfThreads ; i++) {
			worker[i] = new Worker(m);
		}
		for(int i = 0; i < numOfThreads ; i++) {
			worker[i].start();
		}
		
		for (int i = 0; i < numOfThreads; i++) {
            try {
                worker[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		System.out.println(array.get(0));
		
	}

}

