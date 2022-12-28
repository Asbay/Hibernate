package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx= session.beginTransaction();


        Student02 student= session.get(Student02.class,1001);
        System.out.println(student);
        System.out.println(student.getAddress());
/*
ciktisi:::::::::::::
Hibernate:
    select
        student02x0_.id as id1_0_0_,
        student02x0_.city as city2_0_0_,
        student02x0_.country as country3_0_0_,
        student02x0_.street as street4_0_0_,
        student02x0_.zipCode as zipcode5_0_0_,
        student02x0_.grade as grade6_0_0_,
        student02x0_.student_name as student_7_0_0_
    from
        t_student02 student02x0_
    where
        student02x0_.id=?
Student02{id=1001, name='Daffy Kabukcu', grade=90, address=Address{street='Apple street', city='NewYork', country='Us', zipCode='06852'}}
Address{street='Apple street', city='NewYork', country='Us', zipCode='06852'}
 */

        tx.commit();
        session.close();
        sf.close();
    }
}
