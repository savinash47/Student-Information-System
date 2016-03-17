package ll;

import java.util.Arrays;
import java.util.Iterator;

public class OnProbationDecorator extends StudentDecorator {

	public OnProbationDecorator(Decorator<Student> decorator) {
		super(decorator);

	}

	@Override
	public Iterator<Student> iterator() {
		return new ListIterator();
	}

	@Override
	public Object[] toArray() {
		Iterator<Student> iterator = iterator();
		Object[] array = new Object[getSize()];
		int counter = 0;
		while (iterator.hasNext()) {
			array[counter] = iterator.next();
			counter++;
		}
		return array;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E[] toArray(E[] a) {
		Iterator<Student> iterator = iterator();
		int arrayLength = a.length;
		int counter = 0;
		while (iterator.hasNext()) {
			if (arrayLength == counter)
				a = Arrays.copyOf(a, getSize());
			a[counter] = (E) iterator.next();
			counter++;
		}
		return a;
	}

	public String toString() {
		Iterator<Student> iterator = iterator();
		String str = "[";

		while (iterator.hasNext()) {

			if (iterator.hasNext())
				str = str + iterator.next() + " ";
			else
				str = str + iterator.next();
		}
		str = str + "]";
		return str;
	}

	private class ListIterator implements Iterator<Student> {
		OnProbationFilter filter = new OnProbationFilter(getDecorator()
				.iterator());

		@Override
		public boolean hasNext() {
			return filter.hasNext();
		}

		@Override
		public Student next() {
			return filter.next();
		}
	}

	public int getSize() {
		Iterator<Student> iterator = iterator();
		int counter = 0;
		while (iterator.hasNext()) {
			iterator.next();
			counter++;
		}
		return counter;
	}

}
