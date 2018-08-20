package com.one_to_many_uni_directional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW")
public class Review {

	@Id
	@SequenceGenerator(name= "seq_review", allocationSize=1, initialValue=1, sequenceName="SEQ_REVIEW")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_review")
	@Column(name="REVIEW_ID")
	private int id;
	
	@Column(name="C")
	private String comment;
	
	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String comment) {
		super();
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
	
}
