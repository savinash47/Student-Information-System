package ll;

import java.util.Iterator;
import java.util.NoSuchElementException;
// Filter to iterate and find out students on Probation
public class OnProbationFilter implements DoublyLinkedListFilter{

	private Iterator<Student> iterator;
	private Student probationCheck = null;

	public boolean hasNext() {
		if (probationCheck != null) {

			return true;

		} else {
			while (iterator.hasNext()) {
				probationCheck = iterator.next();
				if (probationCheck.onProbation())

					return true;
			}
		}

		return false;
	}

	public Student next() {
		if (hasNext()) {
			Student student = probationCheck;
			probationCheck = null;
			return student;
		} else
			throw new NoSuchElementException();

	}

	public OnProbationFilter(Iterator<Student> iterator) {

		this.iterator = iterator;
	}

}
