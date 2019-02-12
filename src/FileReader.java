import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileReader {
	private static String studentsJSONData;
	private static File file;
	
	public FileReader () throws IOException {
		file = new File("./data/students.json");
		studentsJSONData = FileUtils.readFileToString(file, "utf-8"); 
	}
	
	
	//Convert the JSON to student objects
	private static Student[] convertJSON() {
		
		// Convert JSON string to JSONObject
	    JSONArray studentsJsonObject = new JSONArray(studentsJSONData);
	    
	    Student[] studentObjects = new Student[studentsJsonObject.length()];
	    
	    for (int i = 0; i < studentsJsonObject.length(); i++) {
			JSONObject jsonStudent = studentsJsonObject.getJSONObject(i);
			studentObjects[i] = new Student(jsonStudent.getString("name"), jsonStudent.getFloat("grade"));
	    }
	    
		return studentObjects;
	}
	
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader();
		Student [] students = convertJSON();
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
		}

	}
	
}
