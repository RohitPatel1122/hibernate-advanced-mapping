package com.one_to_many_uni_directional;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name= "COURSES")
public class Course {

	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, name= "course_seq", sequenceName="SEQ_COURSE")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "course_seq")
	@Column(name= "ID")
	private int id;
	
	

	@Column(name="TITLE")
	private String nameOfCourse;
	
	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="COURSE_ID")
	private List<Review> reviews;
	

	public Course(String nameOfCourse) {
		super();
		this.nameOfCourse = nameOfCourse;
		//this.reviews = reviews;
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

	

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	//add review
	public void addReview(Review theReview){
		reviews.add(theReview);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", nameOfCourse=" + nameOfCourse + "]";
	}
	

	
}
