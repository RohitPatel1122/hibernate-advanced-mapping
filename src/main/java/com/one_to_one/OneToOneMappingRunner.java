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

		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory= configuration.buildSessionFactory(serviceRegistry);
		
		Session session= null;
		Transaction t=null;
		
		//create Employee and Address object
		Address address= new Address("KAR", 5500054);
		
		Employee emp= new Employee("rohit patel", address);
		
		session=sessionFactory.openSession();
		t= session.beginTransaction();
		
		session.save(emp);
		t.commit();
		System.out.println("DATA SAVED");
		
		List<Employee> list= session.createQuery("from Employee").list();
		
		for(Employee e: list){
			System.out.println(e.toString());
		}
		
		

	}

}
