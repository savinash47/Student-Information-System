package ll;

public class Node<E> {

	E element;
	Node<E> previous;
	Node<E> next;

	public Node() { }

	public Node(E e) {

		this.element = e;
	}

	public E getData() {
		return element;
	}


}