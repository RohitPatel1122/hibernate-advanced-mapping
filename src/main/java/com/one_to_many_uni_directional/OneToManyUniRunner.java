package com.one_to_many_uni_directional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class OneToManyUniRunner {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();

		configuration.configure("hibernate_one_to_many_uni.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory= configuration
				.buildSessionFactory(serviceRegistry);
		
		Session session= null;
		Transaction t=null;
		
		
		try{
			
			session= sessionFactory.openSession();
			t= session.beginTransaction();
			
			/*//create a course
			Course c1= new Course("JAVA");
			//store in the db
			int id= (int) session.save(c1);
			t.commit();
			session.close();
			//retrieve it
			session= sessionFactory.openSession();
			t= session.beginTransaction();
			Course c2= (Course) session.get(Course.class, id);
			System.out.println("->>"+c2.toString()+"\n ->>"+c2.getReviews());
			//create a review
			Review r= new Review("Good course");
			//add it to course
			c2.addReviews(r);
			//save the course
			session.update(c2);
			t.commit();
			session.close();
		
			System.out.println("DONE SAVING REVIEW");
			session= sessionFactory.openSession();
			t= session.beginTransaction();
			
		 	c2= (Course) session.get(Course.class, id);
			System.out.println(c2+"\n review: "+c2.getReviews().toString());
			*/
			
			Review c2= (Review) session.get(Review.class, 1);
			
			session.delete(c2);
			
			t.commit();
			session.close();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}

	}

}
