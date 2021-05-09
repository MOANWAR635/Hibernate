package com.hibernate.LifeCycleState;
import com.hibernate.LifeCycleState.Student1;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class LifeCycle {

	public static void main(String[] args) {
		System.out.println("Program Started----........");
		//practical hibernate state object
		//Transient 
		//persistence
		//detached
		//removed
		
		SessionFactory factory=(SessionFactoryImpl) new Configuration().configure("hibernate.xml").buildSessionFactory();
		//create a object
		Student1 s1=new Student1();
		//set a data in student object
		
		//transient state
		s1.setId(24);
		s1.setName("Zain");
		s1.setCity("Mubarkpur");
		
		
		
		Student1 s2=new Student1();
		//set a data in student object
		
		//transient state
		s2.setId(21);
		s2.setName("Falak");
		s2.setCity("Azamgarh");
		

		Student1 s3=new Student1();
		//set a data in student object
		
		//transient state
		s3.setId(20);
		s3.setName("Anwarhussain");
		s3.setCity("Azamgarh");
		
		//set a data in Certificate  object
		Certificate1 cer=new Certificate1();
		
		cer.setCourse("Bca");
		cer.setDuration("3 year");
		s1.setCerti(cer);
		s2.setCerti(cer);
		
Certificate1 ce2=new Certificate1();
		
		ce2.setCourse("Mca");
		ce2.setDuration("2 year");
		
		s3.setCerti(ce2);
		
		Session se=factory.openSession();
		Transaction tx=se.beginTransaction();
		
		s1.setCity("Azamgarh");
		s1.setName("Shahabuddin");
		// student :persistence session,databases
		

		
		se.save(s1);
		se.save(s2);
		se.save(s3);
		
		
		String query="from Student1 where id=24";
		//fetching data from databases
		Query  query1=se.createQuery(query);
		
		//Single object (unique)
			//multiple object (list)
			
			List<Student1> list=query1.list();
			for (Student1 fa : list) {
				System.out.println(fa.getName());
				System.out.println(fa.getCerti().getCourse());
			}
		
		/*	//deleting operation from databases
			System.out.println("______________________________________________________");
			
			
		Query qr=se.createQuery("delete from Student1 where id= 21 ");
		
		int  a=qr.executeUpdate();
		
		System.out.println("Data Deleted...........");
		System.out.println(a);*/
		
		// delete operation 	
			
		Query<Student1> q2=	se.createQuery("update Student1 set city=:c where name=:n");
		
		q2.setParameter("c", "Mubarkpur");
		q2.setParameter("n", "Falak");
		int a=q2.executeUpdate();
		
		System.out.println(a+" Object Update");
			
		tx.commit();
		factory.close();
		 se.close();
		
		 
	}

}
