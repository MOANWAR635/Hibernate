package com.hibernate.OneToOneMapping;

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
		question.setAnswer(answer);
		answer.setQuestion(question);
		
		
		
		
		

		Question question1=new Question();
		
		question1.setQuestion_id(565);
		question1.setQuestion("what is collection");
		
		Answer answer1=new Answer();
		answer1.setAnswer_id(56);
		answer1.setAnswer("Collection is a set api and objects");
		question1.setAnswer(answer1);
		
		answer1.setQuestion(question1);
		
		
			Session s= factor.openSession();
			
			Transaction tx=s.beginTransaction();
			//save data
			s.save(question);
			s.save(answer);
			
			s.save(question1);
			s.save(answer1);
		
		tx.commit();
		
		//fetch the data
		Question  que=s.get(Question.class, 565);
		
		System.out.println(que.getQuestion());
		
		System.out.println(que.getAnswer().getAnswer());
		
		factor.close();
		s.close();
		

	}

}
