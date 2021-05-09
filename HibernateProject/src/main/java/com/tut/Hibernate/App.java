package com.tut.Hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
        System.out.println( "Hello World!" );
        System.out.println("Hi Falak Noor");
        
        System.out.println("Program started...");
        
        Configuration cgf=new Configuration();
        cgf.configure("hibernate.xml");
        
        SessionFactoryImpl factroy1 =(SessionFactoryImpl) cgf.buildSessionFactory();
        

        Student st=new Student();
        st.setId(1);
        st.setName("Anwarhussain");
        st.setCity("Azamgarh");
       System.out.println(st);
       
       
        Address ad=new Address();
        ad.setAddress_id(56);
        ad.setStreet("Allauddinpatti");
        ad.setCity("Azamgarh");
        ad.setIsOpen(true);
        ad.setAddedDate(new Date());
        System.out.println(ad);
        System.out.println(factroy1.isClosed());
        System.out.println(factroy1);
        
        FileInputStream fs=new FileInputStream("src/main/java/anwar.jpg");
        byte [] data=new byte[(fs.available())];
        fs.read(data);
        ad.setImage(data);
       
        
        Session sessin=factroy1.openSession();
        
        Transaction ts=sessin.beginTransaction();
        
        sessin.save(st);
        sessin.save(ad);
        ts.commit();
        sessin.close();
      
    }
}
