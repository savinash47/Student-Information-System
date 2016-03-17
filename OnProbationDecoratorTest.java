package ll;

import static org.junit.Assert.*;

import org.junit.*;
//Modifies the list of students on probation into array and string
public class OnProbationDecoratorTest {

	DoublyLinkedList<Student> list;
	Student student1 = new Student("Blacky", 818291598, 2.75);
	Student student2 = new Student("John", 818266664, 2.75);
	Student student3 = new Student("Smith", 851856564, 4.0);
	Student student4 = new Student("Andrew", 817634278, 3.8);
	OnProbationDecorator decorator;

	@Before
	public void addBefore() {
		AddNode<Student> order = new AddStudent();
		list = new DoublyLinkedList<Student>(order);
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		decorator = new OnProbationDecorator(list);
	}

	@Test
	public void testToArray() {

		Object[] testarray;
		testarray = decorator.toArray();

		assertEquals(student1.name, ((Student) testarray[0]).name);
		assertEquals(student2.name, ((Student) testarray[1]).name);
	}

	@Test
	public void testgetSize() {
		assertEquals(2, decorator.getSize());

	}

	@Test
	public void testToArray2() {

		Object[] testarray1 = new Object[2];
		Object[] testarray = decorator.toArray(testarray1);
		assertEquals(student1.name, ((Student) testarray[0]).name);
		assertEquals(student2.name, ((Student) testarray[1]).name);
	}

	@Test
	public void testToString() {
		String testString = decorator.toString();
		assertTrue(testString.contains(student1.toString()));
		assertTrue(testString.contains(student2.toString()));

	}
}
