package ll;
//Null Node to represent the head and the tail
public class NullNode<E> extends Node<E> {
	public NullNode() {
	}

	@Override
	public E getData() {
		return null;
	}
}
