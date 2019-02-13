import java.util.Comparator;

public class Student implements Comparator<Student>, Comparable<Student>{
	
	private String name;
	private float grade;
	
	public Student (String name, float grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName () {
		return this.name;
	}
	
	public float getGrade () {
		return this.grade;
	}
	
	//compare by name
	public int compareTo(Student s) {
		return (this.getName()).compareTo(s.getName());
	}
	
	//compare by grade
	public int compare(Student s1, Student s2) {
		// cast result to int
		return Math.round(s1.getGrade()-s2.getGrade());
	}
	
	// Return string representation of the object
	public String toString() {	
		return "name: " + this.name+ "\n"
				+ "grade: " + this.grade+ "\n";
	}
	
}
