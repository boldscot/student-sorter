import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class TestSorting {

	private final Student STUDENT_A = new Student("A", 10.0f);
	private final Student STUDENT_B = new Student("B", 100.0f);
	private final Student STUDENT_C = new Student("C", 50.0f);
	
	private ArrayList<Student> studentTestObjects =  new ArrayList<Student>();
	
	@Test
	public void TestNameSort() {
		studentTestObjects.add(STUDENT_C);
		studentTestObjects.add(STUDENT_A);
		studentTestObjects.add(STUDENT_B);
		
		assertEquals(studentTestObjects.get(0), STUDENT_C);
		assertEquals(studentTestObjects.get(1), STUDENT_A);
		assertEquals(studentTestObjects.get(2), STUDENT_B);
		
		Collections.sort(studentTestObjects);
		
		assertEquals(studentTestObjects.get(0), STUDENT_A);
		assertEquals(studentTestObjects.get(1), STUDENT_B);
		assertEquals(studentTestObjects.get(2), STUDENT_C);
				
	}
	
	@Test
	public void TestGradeSort() {
		studentTestObjects.add(STUDENT_A);
		studentTestObjects.add(STUDENT_B);
		studentTestObjects.add(STUDENT_C);
		
		assertEquals(studentTestObjects.get(0), STUDENT_A);
		assertEquals(studentTestObjects.get(1), STUDENT_B);
		assertEquals(studentTestObjects.get(2), STUDENT_C);
		
		Collections.sort(studentTestObjects, new Student());
		
		assertEquals(studentTestObjects.get(0), STUDENT_B);
		assertEquals(studentTestObjects.get(1), STUDENT_C);
		assertEquals(studentTestObjects.get(2), STUDENT_A);
	}

}
