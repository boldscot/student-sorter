import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileReader {
	public FileReader () {}
	
	//Read JSON file and Convert the JSON to student objects
	public ArrayList<Student> parseJSON(File f) throws IOException {
		// Parse file contents to a string
		String studentsJSONData = FileUtils.readFileToString(f, "utf-8"); 
		
		// Convert string to json array
	    JSONArray studentsJSONArrayList= new JSONArray(studentsJSONData);
	    
	    // Declare arraylist of student objects, size == to the size of json array
	    ArrayList<Student> studentObjects = new ArrayList<Student>();
	    
	    // Iterate over json array and create a student object for each index
	    for (int i = 0; i < studentsJSONArrayList.length(); i++) {
			JSONObject jo = studentsJSONArrayList.getJSONObject(i);
			studentObjects.add(new Student(jo.getString("name"), jo.getFloat("grade")));
	    }
	    
		return studentObjects;
	}
	
	// Read csv file and convert to Student objects
	public ArrayList<Student> parseCSV(String url) throws IOException {
		// Create a buffered reader for the file 
		Reader r = Files.newBufferedReader(Paths.get(url));
		
		// pass the reader to the CSVParser
		CSVParser csvp = new CSVParser(r, CSVFormat.DEFAULT
				.withFirstRecordAsHeader()
                .withTrim());
		
		// Arraylist to store student objects
		ArrayList<Student> studentObjects = new ArrayList<Student>();
		
		// Create a student object for each record in the parser
		for (CSVRecord rec : csvp) {
			studentObjects.add(new Student(rec.get("name"), Float.parseFloat(rec.get("grade"))));
		}
		
		return studentObjects;
	}
	
}
