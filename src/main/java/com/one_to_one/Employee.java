package com.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "EMPLOYEE")
public class Employee {

	@Id
	@SequenceGenerator(allocationSize=1, name="seq", sequenceName="HIBERNATE_SEQUENCE")
	@GeneratedValue(generator="seq", strategy= GenerationType.SEQUENCE)
	@Column(name="ID")
	
	private int id;
	@Column(name= "NAME")
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	public Employee(String name, Address address) {
		
		this.name = name;
		this.address= address;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee() {
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
