package com.hibernate.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class Testclass {

	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.xml");
		
		SessionFactoryImpl factor=(SessionFactoryImpl) cfg.buildSessionFactory();
		
		
		Question question=new Question();
		
		question.setQuestion_id(1212);
		question.setQuestion("What is java");
		
		Answer answer=new Answer();
		answer.setAnswer_id(33);
		answer.setAnswer("java is a programming language");
		answer.setQuestion(question);
		
		Answer answer1=new Answer();
		answer1.setAnswer_id(86);
		answer1.setAnswer("Java is most pawer full language");
		answer1.setQuestion(question);
		
		
		Answer answer2=new Answer();
		answer2.setAnswer_id(56);
		answer2.setAnswer("We can make multiple type  of application with help of java programming ");
		answer2.setQuestion(question);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		question.setAnswer(list);
		
		
			Session s= factor.openSession();
			
			Transaction tx=s.beginTransaction();
			//save data
			
		s.save(question);
		s.save(answer); 
		s.save(answer1);
		s.save(answer2);
		tx.commit();
		
		//fetch the data

		
		factor.close();
		s.close();
		

	}

}
