# Hibernate Advanced Mapping using Annotation

***


In this project, we will doing hibernate advanced mapping, which are:
### 1. One To One 
### 2. One To Many (Uni Directional and bi-directional) / Many To One
### 3. Many To Many

***
## SET UP OF BASIC STRUCTURE:

1. Beans: Student and StudentDetails

Student class has id and name as properties. 
StudentDetails has id, fatherName as properties.

## ONE TO ONE MAPPING: 
To create a uni directional one-to-one relation ship, between student and studentDetails:
  1. Add property StudentDetails in Student bean (as Student will hold the foreign key to student details)
  
  2. Add @OneToOne (cascade= CascadeType.<type>, fetch= FetchType.LAZY ) annotation to it. This tell hibernate, that Student has one-to-one relationship with studentDetails. 'cascade= CascadeType.<Type>' property of @OneToOne, will cascade two beans as per the type
  3. Add @JoinColumn (name= "<name of FK column in student table>").
  
In order to create a bi directional relation ship:
  1. step 1,2 same as above.
  2. create Student property in studentDetails bean
  2. Add @OneToOne(mappedBy= <studentDetails property from student bean>) to student property.
  

