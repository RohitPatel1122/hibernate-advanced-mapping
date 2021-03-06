package com.many_to_many;

import java.util.ArrayList;
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
@Table(name = "STUDENT")
public class Student {

	@Id
	@SequenceGenerator(allocationSize = 1, name = "stu_seq", sequenceName = "SEQ_STUDENT")
	@GeneratedValue(generator = "stu_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;

	
	//@ManyToMany->tells many student can have many courses.
	
	@ManyToMany(fetch= FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
				name="student_course",
				joinColumns= @JoinColumn(name="STUDENT_ID"),
				inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> courses;
	
	public Student(String name) {
		this.name = name;
		
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course theCourse){
		courses.add(theCourse);
		//theCourse.setStudent(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
