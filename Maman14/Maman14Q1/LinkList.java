
public class LinkList <E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private Node<E> temp = null;

	public LinkList() {};

	public Node<E> getHead(){
		return head;
	}

	public Node<E> getTail(){
		return tail;
	}

	public void add(Node<E> node) {
		if (head == null) {
			head= node;
			tail=node;
		}
		else {
			tail.setNextNode(node);
			tail = node;
		}
	}

	public E remove() throws EmptyListException{
		if(head == null) {
			throw new EmptyListException();
		}
		temp = head;
		head = head.getNextNode();
		if(head == null) {
			tail = null;
		}
		return temp.getContent();
	}
	public String toString() {
		Node<E> temp = head;
		String string = head.toString();
		while(temp.getNextNode() != null) {
			temp = temp.getNextNode();
			string = string + " -> " + temp.toString();
		}
		return string;
	}
}
