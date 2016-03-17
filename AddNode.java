package ll;

public interface AddNode<E> {
	void addition(Node<E> newNode,Node<E> head, Node<E> tail);
    Node<E> getHead();
    Node<E> getTail();
}
