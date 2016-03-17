package ll;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {

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
	}

	@Test
	public void testAddNode() {

		assertEquals(4, listObject.size());
	}

	@Test
	public void testPrintKthElement() {
        
		Student expectedStudent = listObject.get(2);
		assertSame(student2, expectedStudent);
		assertSame(student3, listObject.get(3));
	}

	@Test
	public void kthElementException() {

		try {
			listObject.get(5);
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testOrder() {

		Student[] studentList = { student4, student1, student2, student3 };
		Node<Student> current = listObject.getHead();
		for (int i = 0; i < studentList.length; i++) {
			assertEquals(studentList[i], current.element);
			current = current.next;
		}
	}

	@Test
	public void testToArray() {

		Object[] testArray = listObject.toArray();
		assertEquals(student2.name, ((Student) testArray[2]).name);
	}

	@Test
	public void testToArray2() {

		Object[] testarray1 = new Object[0];
		Object[] testarray = listObject.toArray(testarray1);
		assertEquals(student2.name, ((Student) testarray[2]).name);
	}

	public void testToString() {
		String testString = listObject.toString();
		assertTrue(testString.contains(student1.toString()));
		assertTrue(testString.contains(student2.toString()));
		assertTrue(testString.contains(student3.toString()));
		assertTrue(testString.contains(student4.toString()));
	}
    @Test
	public void testHasNext() {
		Iterator<Student> iterator = listObject.iterator();
		Student[] studentList = { student4, student1, student2, student3 };
		int count = 0;
		while (iterator.hasNext()) {

			iterator.next();
			count++;
		}
		assertEquals(count, studentList.length);
	}


  @Test
  public void testNext(){ 
      Iterator<Student> iterator = listObject.iterator();
	  Student[] studentList = { student4, student1, student2, student3 }; 
	  while(iterator.hasNext()) { iterator.next(); }
  assertEquals(student1.name, studentList[1].name);
  assertEquals(student4.name, studentList[0].name); }
 
}
