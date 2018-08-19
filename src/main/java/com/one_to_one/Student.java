package com.one_to_one;

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

import com.one_to_many.Course;

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

	// @OneToOne- tell hibernate that studentDetails and Student has one-to-one
	// mapping
	// this is uni-directional relationship (Student->studentDetails)
	// to get bi-directional, add @OneToOne(mappedby= "<studentDetails property
	// in student class>") to the student property in studentDetails class
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_DETAILS_ID")
	private StudentDetails studentDetails;

	@OneToMany( mappedBy="student",fetch= FetchType.LAZY, 
			cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Course> courses;
	
	public Student(String name, StudentDetails studentDetails) {
		super();
		this.name = name;
		this.studentDetails = studentDetails;
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

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
