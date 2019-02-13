import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Sorter {
	private final static File JSON_FILE = new File("./data/students.json");;
	private final static String CSV_FILE = "./data/students.csv";
	private static ArrayList<Student> studentJSONObjects;
	private static ArrayList<Student> studentCSVObjects;
	
	public static void main(String args[]) {
		// instantiate a file reader object
		FileRead fr = new FileRead();
		//Instantiate a file writer object
		FileWrite fw = new FileWrite();
		
		try {
			studentJSONObjects = fr.parseJSON(JSON_FILE);
			studentCSVObjects = fr.parseCSV(CSV_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(studentJSONObjects);
		try {
			fw.writeToJSONFile("student_name", studentJSONObjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(studentJSONObjects, new Student());
		try {
			fw.writeToJSONFile("student_grade", studentJSONObjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(studentCSVObjects);
		try {
			fw.writeToCSVFile("student_name", studentCSVObjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(studentCSVObjects, new Student());
		try {
			fw.writeToCSVFile("student_grade", studentCSVObjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

}
