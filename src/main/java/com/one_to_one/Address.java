package com.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Id
	@SequenceGenerator(allocationSize=1, name="seq", sequenceName="HIBERNATE_SEQUENCE")
	@GeneratedValue(generator="seq", strategy= GenerationType.SEQUENCE)
	@Column(name="ID")
	private int id;
	
	@Column(name="STATE")
	private String state;
	@Column(name= "PINCODE")
	private int pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String state, int pincode) {
		super();
		this.state = state;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", state=" + state + ", pincode=" + pincode + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
