public class Worker extends Thread {
	private Manager m;
	private int[] nums;
	public Worker(Manager m) {
		this.m = m;
	}

	public void run() {
		super.run();
		while (m.moreSums()) {
			if((nums = m.allocateNumbers()) != null){
				int sum = nums[0] + nums[1];
				m.addSum(sum);
			}
		}
	}
}