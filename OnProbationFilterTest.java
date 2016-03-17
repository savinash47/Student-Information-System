package ll;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OnProbationFilterTest {
	OnProbationFilter filter;
	DoublyLinkedList<Student> listObject;
	Student student1 = new Student("Blacky", 818291598, 2.75);
	Student student2 = new Student("John", 818266664, 2.75);
	Student student3 = new Student("Smith", 851856564, 4.0);
	Student student4 = new Student("Andrew", 817634278, 3.8);

	@Before
	public void addBefore() {
		AddNode<Student> order = new AddStudent();
		listObject = new DoublyLinkedList<Student>(order);
		listObject.add(student1);
		listObject.add(student2);
		listObject.add(student3);
		listObject.add(student4);
		filter = new OnProbationFilter(listObject.iterator());
	}

	@Test
	public void testHasNext() {
		List<Student> students = new ArrayList<Student>();
		int count = 0;
		while (filter.hasNext()) {
			students.add(filter.next());
			count++;
		}
		assertEquals(count, students.size());
	}

	@Test
	public void testNext() {
		List<Student> students = new ArrayList<Student>();
		while (filter.hasNext()) {
			students.add(filter.next());
		}

		assertEquals(student1.name, students.get(0).name);
		assertEquals(student1.redID, students.get(0).redID);
		assertEquals(student2.name, students.get(1).name);
		assertEquals(student2.redID, students.get(1).redID);
		
		}

}
