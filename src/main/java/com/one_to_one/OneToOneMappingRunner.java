package com.one_to_one;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class OneToOneMappingRunner {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate_one_to_one.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);
		
		Session session= null;
		Transaction t=null;
		
		//create Student and StudentDetails object
		try{
		/*StudentDetails studentDetails = new StudentDetails("Dinesh Patel", "Playing Cricket");
		Student student= new Student( "Rohit",studentDetails );
		
		session=sessionFactory.openSession();
		t= session.beginTransaction();
		System.out.println("SAVING STUDENT");
		student.setId((int) session.save(student));
		t.commit();
		System.out.println("DATA SAVED");*/
		
		
		
		
		Student student = null;
		session= sessionFactory.openSession();
		t= session.beginTransaction();
		int id=2;
		student= (Student) session.get(Student.class, id);
		System.out.println("\n\n -> DELETING STUDENT: "+student);
		
		session.delete(student);
		
		t.commit();
		System.out.println("DELETED STUDENT :");
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(session.isOpen()){
			session.close();
			}
		}
		

	}

}
