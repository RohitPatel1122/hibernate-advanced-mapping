package com.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="STUDENT_DETAILS")
public class StudentDetails {
	
	@Id
	@SequenceGenerator(allocationSize=1, name="student_details_seq", sequenceName="SEQ_STUDENT_DETAILS")
	@GeneratedValue(generator="student_details_seq", strategy= GenerationType.SEQUENCE)
	@Column(name="ID")
	private int id;
	
	@Column(name="FATHER_NAME")
	private String fatherName;
	
	@Column(name= "HOBBY")
	private String hobby;
	
	//@OneToOne(mappedBy= "studentDetails") gived bi-directional functionality
	@OneToOne(mappedBy= "studentDetails", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	private Student student;
	
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDetails(String fatherName, String hobby) {
		
		this.fatherName = fatherName;
		this.hobby = hobby;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", fatherName=" + fatherName + ", hobby=" + hobby + "]";
	}

	
	
	
}
