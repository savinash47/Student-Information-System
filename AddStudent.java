package ll;
//Add students in lexicographical order
public class AddStudent implements AddNode<Student> {
	private Node<Student> head, tail;

	public void addition(Node<Student> newNode, Node<Student> head,
			Node<Student> tail) {
		this.head = head;
		this.tail = tail;
		Node<Student> last = null;
		Node<Student> current = head;

		while (current != null
				&& (current.element.getStudentName())
						.compareToIgnoreCase(newNode.element.getStudentName()) < 0) {

			last = current;
			current = current.next;
		}
		newNode.previous = last;
		newNode.next = current;

		if (newNode.previous != null)
			last.next = newNode;
		else
			this.head = newNode;

		if (newNode.next != null)
			current.previous = newNode;
		else
			this.tail = newNode;
	}

	public Node<Student> getHead() {
		return head;
	}

	public Node<Student> getTail() {
		return tail;
	}
}
