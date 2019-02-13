import java.util.Comparator;

import com.google.common.base.Objects;


public class Student implements Comparator<Student>, Comparable<Student> {
	
	private String name;
	private float grade;
	
	public Student (String name, float grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public Student() {}
	
	public String getName () {
		return this.name;
	}
	
	public float getGrade () {
		return this.grade;
	}
	
	//compare by name
	@Override
	public int compareTo(Student s) {
		return (this.getName()).compareTo(s.getName());
	}
	
	//compare by grade
	@Override
	public int compare(Student s1, Student s2) {
		// cast result to int
		return Math.round(s2.getGrade()-s1.getGrade());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.name, this.grade);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Student) {
			final Student other = (Student) obj;
			return Objects.equal(name, other.name)
					&& Objects.equal(grade, other.grade);
		} else {
			return false;
		}
	}
	
	// Return string representation of the object
	public String toString() {	
		return "name: " + this.name+ "\n"
				+ "grade: " + this.grade+ "\n";
	}
	
}
