
public class Max {
	public static <E extends Comparable<E>> E max (LinkList<E> list) {
		Node<E> runner = list.getHead();
		E runnerCont;
		E max = runner.getContent();
		while(runner.getNextNode()!= null) {
			runner = runner.getNextNode();
			runnerCont = runner.getContent();
			if (runnerCont.compareTo(max) == 1) {
				max = runnerCont;
			}
		}
		return max;
	}

}
