public class Node<E> {
	private E content;
	private Node<E> nextNode;

	public Node(E content) {
		this.content = content;
		this.nextNode = null;
	}

	public Node(E content, Node<E> nextNode) {
		this.content = content;
		this.nextNode = nextNode;
	}

	public E getContent() {
		return content;
	}

	public void setContent(E content) {
		this.content = content;
	}

	public Node<E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}

	public String toString() {
		return content.toString();
	}
}