package com.one_to_many_bi_directional;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	
	//@OneToMany->tells one student can have many courses.
	//mappedBy tells, to look for the student property in Course class, and map to it.
	@OneToMany( mappedBy="student",fetch= FetchType.LAZY, 
			cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
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
		
		if(this.courses==null){
			courses= new ArrayList<Course>();
		}
		courses.add(theCourse);
		
		//add bi-directional relationship
		theCourse.setStudent(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
