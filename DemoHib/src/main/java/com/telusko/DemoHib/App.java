package com.telusko.DemoHib;



import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        AlienName an=new AlienName();
//        an.setFname("Thalapati");
//        an.setMname("navin");
//        an.setLname("reddy");
//        Alien a1=new Alien();
//        a1.setAid(5);
//        a1.setAname(an);
//        a1.setColor("red");
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        SessionFactory sf=con.buildSessionFactory(reg);
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();
//        //save method save data in database
//        session.save(a1);
//        //Retriving data from table
//        Alien RData=new Alien();
//        RData=(Alien) session.get(Alien.class, 1);
        
        Laptop L1=new Laptop();
        L1.setLid(102);
        L1.setLname("asus");
       
        Student s=new Student();
        s.setId(1);
        s.setName("Navneet");
        s.getLaptop().add(L1);
        L1.getStudent().add(s.getId());
        session.save(L1);
        session.save(s);
        
       // Student s1=(Student) session.get(Student.class, 1);
//        System.out.println(s1.getName());
//        Collection<Laptop> lap=s1.getLaptop();
//        for(Laptop l : lap)
//        {
//        	System.out.println(l);
//        }
        tx.commit();
        
        //System.out.println(RData);
    }
}
