package ll;

import java.util.*;

public class DoublyLinkedList<E> implements Iterable<E>, List<E>, Decorator<E> {
	private Node<E> head, tail;
	private int size;

	private AddNode<E> add;

	public DoublyLinkedList(AddNode<E> add) {
		head = new NullNode<E>();
		tail = new NullNode<E>();
		size = 0;
		this.add = add;
	}

	public Node<E> getHead() {
		return head;
	}

	public boolean add(E element) {
		Node<E> newNode = new Node<E>(element);
		if (head.getData() == null) {
			head = tail = newNode;

		} else {
			add.addition(newNode, head, tail);
			head = add.getHead();
			tail = add.getTail();
		}

		size++;
		return true;
	}
    //Get the Kth element in list
	public E get(int k) {
		Node<E> kElement = head;
		if (k < 0 || k > size)
			throw new IndexOutOfBoundsException();
		else
			for (int i = 0; i < k; i++)
				kElement = kElement.next;
		return kElement.element;
	}
    //Main Function
	public static void main(String[] args) {

		Student student1 = new Student("Blacky", 818291598, 2.75);
		Student student2 = new Student("John", 818266664, 2.75);
		Student student3 = new Student("Smith", 851856564, 4.0);
		Student student4 = new Student("Andrew", 817634278, 3.8);
		Student student5 = new Student("Robert", 816984613, 4.0);
		List<Student> listObject = new DoublyLinkedList<Student>(
				new AddStudent());

		listObject.add(student1);

		listObject.add(student2);

		listObject.add(student3);

		listObject.add(student4);
		listObject.add(student5);

	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<E> {
		Node<E> current = head;

		@Override
		public boolean hasNext() {

			return current != null;
		}

		@Override
		public E next() {
			E temp = current.element;
			current = current.next;
			return temp;
		}
	}
    
	//This are the list methods which we can over ride but in this Project I only overridden the 2 toArray methods and a toString method
	@Override
	public void add(int arg0, E arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public java.util.ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		Node<E> temp = head;

		Object[] array = new Object[size()];
		for (int i = 0; i < size; i++) {
			array[i] = temp.getData();
			temp = temp.next;
		}
		return array;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {

		int length = a.length;
		Node<T> temporary = (Node<T>) head;

		for (int i = 0; i < size(); i++) {
			if (length == i)
				a = Arrays.copyOf(a, size());
			a[i] = temporary.getData();
			temporary = temporary.next;
		}
		return a;
	}

	// @Override
	public String toString() {
		Node<E> current = head;
		String str = "[";
		for (int i = 0; i < size(); i++) {
			if (i != size() - 1)
				str = str + current.getData() + " ";
			else
				str = str + current.getData();
			current = current.next;
		}
		str = str + "]";
		return str;
	}
}