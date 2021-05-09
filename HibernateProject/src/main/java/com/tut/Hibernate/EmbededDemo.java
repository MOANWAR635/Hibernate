package com.tut.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class EmbededDemo {

	public static void main(String[] args) {


		 Configuration cgf=new Configuration();
	        cgf.configure("hibernate.xml");
	        
	        SessionFactory factroy1 =(SessionFactoryImpl) cgf.buildSessionFactory();
	        
	        
	        Student student=new Student();
	        
	       student.setId(786);
	        student.setName("Anwarhussain");
	       student.setCity("Azamgarh");
	        
	        Certificate certificate=new Certificate();
	        certificate.setCourse("Android");
	        certificate.setDuration("4 months");
	        student.setCerti(certificate);
	        
	        
	        Student student1=new Student();
	        
	       student1.setId(11);
	        student1.setName("Mo Kamran");
	       student1.setCity("Azamgarh");
	        
	        Certificate certificate1=new Certificate();
	        certificate1.setCourse("JavaProgramming");
	        certificate1.setDuration("1  year");
	        student1.setCerti(certificate1);
	        
	        
	        
	       /* Student student1=new Student();
	        
		       student.setId(12);
		        student.setName("Mo Kamra");
		       student.setCity("Azamgarh");
		        
		        Certificate certificate1=new Certificate("Android", "1 year");
		        
		        student.setCerti(certificate1);*/
	        
	       // certificate.setCourse("Android");
	        //certificate.setDuration("2 month");
	 
	        Session session =factroy1.openSession();
	        Transaction ts=session.beginTransaction();
	        //objects save
	        
	        session.save(student);
	        session.save(student1);
	        ts.commit(); 
	        session.close();

	}

}
