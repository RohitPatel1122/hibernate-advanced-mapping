package com.many_to_many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name= "COURSES")
public class Course {

	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, name= "course_seq", sequenceName="SEQ_COURSE")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "course_seq")
	@Column(name= "COURSE_ID")
	private int id;
	
	@Column(name="TITLE")
	private String nameOfCourse;
	
	//@ManyToMany->many courses can be assigned to one student
	//@JoinColumn-> tell to which column to map it.
	@ManyToMany(fetch= FetchType.LAZY, 
				cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	//column in course table (FK)
	@JoinTable(name="student_course",
				joinColumns= @JoinColumn(name="COURSE_ID"),
				inverseJoinColumns=@JoinColumn(name="STUDENT_ID"))
	private List<Student> student; 
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", nameOfCourse=" + nameOfCourse + ", student_ID=" + student + "]";
	}

	public Course() {
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfCourse() {
		return nameOfCourse;
	}

	public void setNameOfCourse(String nameOfCourse) {
		this.nameOfCourse = nameOfCourse;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
	public void addStudent(Student theStudent){
		student.add(theStudent);
	}
	
	public Course(String nameOfCourse) {
		
		this.nameOfCourse = nameOfCourse;
		
	}

	
}
