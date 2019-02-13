import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Sorter {
	private final static File JSON_FILE = new File("./data/students.json");;
	private final static String CSV_FILE = "./data/students.csv";
	private static Student[] studentJSONObjects;
	private static ArrayList<Student> studentCSVObjects;
	
	public static void main(String args[]) {
		// instantiate a file reader object
		FileReader fr = new FileReader();
		
		try {
			studentJSONObjects = fr.parseJSON(JSON_FILE);
			studentCSVObjects = fr.parseCSV(CSV_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < studentJSONObjects.length; i++) {
			System.out.println(studentJSONObjects[i].toString());
		}
		
		for (Student s : studentCSVObjects) {
			System.out.println(s.toString());
		}
		
	}

}
