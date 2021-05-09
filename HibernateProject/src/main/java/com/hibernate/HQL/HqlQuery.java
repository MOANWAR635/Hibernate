package com.hibernate.HQL;
import java.util.List;
import com.hibernate.LifeCycleState.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

import com.hibernate.LifeCycleState.Student1;

public class HqlQuery {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.xml");
		
		SessionFactory factory=(SessionFactoryImpl)cfg.buildSessionFactory();
		
		
		Session s=factory.openSession();
		
		Transaction tx=s.beginTransaction();
		
		String query="from Student1";
		
			
		
		tx.commit();
		factory.close();
		s.close();
	}

}
