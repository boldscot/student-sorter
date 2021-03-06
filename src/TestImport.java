import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class TestImport {
	private final FileRead fr = new FileRead();
	private final Student STUDENT_A = new Student("A", 10.0f);
	private final Student STUDENT_B = new Student("B", 100.0f);
	private final Student STUDENT_C = new Student("C", 50.0f);
	
	private final File JSON_FILE = new File("./testData/test.json");
	private final String CSV_FILE = "./testData/test.csv";
	
	private ArrayList<Student> studentTestObjects =  new ArrayList<Student>();
	private ArrayList<Student> studentTestFileData = new ArrayList<Student>();
	
	@Test
	public void TestJSONImport() throws IOException {
		studentTestObjects.add(STUDENT_A);
		studentTestObjects.add(STUDENT_B);
		studentTestObjects.add(STUDENT_C);
		
		// Testing the equals() overriding in student
		assertNotEquals(STUDENT_A, STUDENT_B);
		assertEquals(STUDENT_C, STUDENT_C);
		assertEquals(STUDENT_A, STUDENT_A);
		assertNotEquals(STUDENT_A, new Object());
		assertEquals(STUDENT_A.hashCode(), STUDENT_A.hashCode());
		assertNotEquals(STUDENT_A.hashCode(), STUDENT_B.hashCode());;
		
		studentTestFileData = fr.parseJSON(JSON_FILE);
		
		assertEquals(studentTestFileData.size(), 3);
		assertEquals(studentTestFileData.get(0), STUDENT_A);
		assertEquals(studentTestFileData.get(1), STUDENT_B);
		assertEquals(studentTestFileData.get(2), STUDENT_C);
		
		studentTestFileData.clear();
	}
	
	@Test
	public void TestCSVImport() throws IOException {
		studentTestObjects.add(STUDENT_A);
		studentTestObjects.add(STUDENT_B);
		studentTestObjects.add(STUDENT_C);
		
		studentTestFileData = fr.parseCSV(CSV_FILE);
		
		assertEquals(studentTestFileData.size(), 3);
		assertEquals(studentTestFileData.get(0), STUDENT_A);
		assertEquals(studentTestFileData.get(1), STUDENT_B);
		assertEquals(studentTestFileData.get(2), STUDENT_C);
		
		studentTestFileData.clear();
	}

}
