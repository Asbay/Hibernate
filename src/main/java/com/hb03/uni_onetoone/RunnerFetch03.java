package com.hb03.uni_onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // student fetch(get) ediyoruz, id ile
        Student03 student = session.get(Student03.class, 1001);

        //diary fetch ediyoruz
        Diary diary = session.get(Diary.class, 101);

        System.out.println(student);
        System.out.println("***********************");
        System.out.println(diary);
        System.out.println("***********************");
        System.out.println(diary.getStudent());

        tx.commit();
        session.close();
        sf.close();
    }
    /*
    Hibernate:
    select
        student03x0_.id as id1_1_0_,
        student03x0_.grade as grade2_1_0_,
        student03x0_.std_name as std_name3_1_0_
    from
        Student03 student03x0_
    where
        student03x0_.id=?
Hibernate:
    select
        diary0_.id as id1_0_0_,
        diary0_.name as name2_0_0_,
        diary0_.std_id as std_id3_0_0_,
        student03x1_.id as id1_1_1_,
        student03x1_.grade as grade2_1_1_,
        student03x1_.std_name as std_name3_1_1_
    from
        Diary diary0_
    left outer join
        Student03 student03x1_
            on diary0_.std_id=student03x1_.id
    where
        diary0_.id=?
Student03{id=1001, name='Atılgan Ulaşan', grade=90}
***********************
Diary{id=101, name='Atılgan Beyin Günlüğü', student=Student03{id=1001, name='Atılgan Ulaşan', grade=90}}
***********************
Student03{id=1001, name='Atılgan Ulaşan', grade=90}

     */
}
