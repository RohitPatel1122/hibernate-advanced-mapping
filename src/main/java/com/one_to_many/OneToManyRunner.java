package com.one_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class OneToManyRunner {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();

		configuration.configure("hibernate_one_to_many.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory= configuration
				.buildSessionFactory(serviceRegistry);
		
		Session session= null;
		Transaction t=null;
		
		
		try{
			
			session= sessionFactory.openSession();
			t= session.beginTransaction();
			
			Student s1= new Student ("A");
			Student s2= new Student ("B");
			Course c1=new Course("PHY");
			Course c2=new Course("CHEM");
			
			System.out.println("->>SAVING STUDENTs");
			int s1_id= (int) session.save(s1);
			session.save(s2);
			System.out.println("->>SAVED COMPLETE. \n ->> SAVING COURSE");
			int c_id= (int) session.save(c1);

			session.save(c2);
			
			System.out.println("->>COURSES SAVE COMPLETE");
			t.commit();
			session.close();
			System.out.println("->>SESSION CLOSED");
			
			session= sessionFactory.openSession();
			t= session.beginTransaction();
			//retrieve student
			System.out.println("->>RETRIVING STUDENT WITH ID: "+s1_id);
			s1= (Student) session.get(Student.class, s1_id);
			System.out.println("->> "+s1);
			System.out.println("->>RETRIVING COURSE WITH ID: "+c_id);
			Course c= (Course)session.get(Course.class, c_id);
			System.out.println("->> "+c);
			//add course
			
			System.out.println("->> ADDING COURSE TO STUDENT WIHT ID: "+s1_id);
			s1.addCourse(c);
			System.out.println("->>COURSE ADDED");
			session.update(s1);
			t.commit();
			session.close();
			System.out.println("DONE");

			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}

	}

}
