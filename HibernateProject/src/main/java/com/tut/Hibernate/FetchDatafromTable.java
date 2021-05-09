package com.tut.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class FetchDatafromTable 
{
	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.xml");
		
		SessionFactoryImpl factory=(SessionFactoryImpl) cfg.buildSessionFactory();
		
		Session session=(Session) factory.openSession();
		
		Student student=session.load(Student.class, 1);
		System.out.println(student);
		
		/*Address address=session.get(Address.class, 1);
		System.out.println(address.getCity());
		
		Address address1=session.get(Address.class, 1);
		System.out.println(address1.getCity());*/
		
		factory.close();
		session.close();
		
		
		
		
		
		
		
	}
}
