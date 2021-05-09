package com.hibernate.ManyToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class Test {

	public static void main(String[] args) {
	
		
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.xml");
		
		SessionFactoryImpl factor=(SessionFactoryImpl) cfg.buildSessionFactory();
		
		//create of employee a object
		
		Emp e1=new Emp();
		Emp e2=new Emp();
		
		e1.setEid(11);
		e1.setEname("Anwarhussain");
		e2.setEid(12);
		e2.setEname("Sahab");
		//create of Project a object
		
		Project p1=new Project();
		p1.setPid(56);
		p1.setProjectName("Library Management System");
		Project p2=new Project();
		p2.setPid(57);
		p2.setProjectName("Paying Guest finder");
		
		List<Emp> list1=new ArrayList<Emp>();
		list1.add(e1);
		list1.add(e2);
		
		
		List<Project> list2=new ArrayList<Project>();
		list2.add(p1);
		list2.add(p2);
		
		
		
		e1.setProject(list2);
		p2.setEmp(list1);
		
		e2.setProject(list2);
		p2.setEmp(list1);
		
		Session s=factor.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		s.close();
		

	}

}
