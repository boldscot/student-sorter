import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;

public class FileWrite {
	public FileWrite() {}
	
	public void writeToJSONFile(String fileName, ArrayList<Student> s) throws IOException {
			File f = new File("./data/"+fileName+".json");
			
			if(f.exists()) f.delete();
			
			FileWriter fw = new FileWriter(f);
			
			JSONArray jsaArray = new JSONArray();
			
			for (Student student : s) {
				JSONObject jsonObj = new JSONObject();
				
				jsonObj.put("name", student.getName());
				jsonObj.put("grade", student.getGrade());
				
				jsaArray.put(jsonObj);
			}
			
			fw.write(jsaArray.toString());
			fw.close();
	}
	
	public void writeToCSVFile(String fileName, ArrayList<Student> s) throws IOException {
		String filePath = "./data/"+fileName+".csv";
		
		File f =  new File(filePath);
		if(f.exists()) f.delete();
		
		BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath));
		
		@SuppressWarnings("resource")
		CSVPrinter printer = new CSVPrinter(bw, CSVFormat.DEFAULT
				.withHeader("name", "grade"));
		
		for (Student student : s) {
			printer.printRecord(student.getName(), student.getGrade());
		}
		
		printer.flush();
	}
}
