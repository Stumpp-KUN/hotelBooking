package com.example.trosyproject.DB;

import com.example.trosyproject.Biznes;
import com.example.trosyproject.DB.RegUserDB;
import com.example.trosyproject.Econom;
import com.example.trosyproject.Normal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountDB {

    public int getCount(int k) throws SQLException {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).addAnnotatedClass(Econom.class).addAnnotatedClass(Normal.class).addAnnotatedClass(Biznes.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        switch (k) {
            case 0: {
                session.beginTransaction();
                List<RegUserDB> us=session.createQuery("from Econom ").getResultList();
                int count=us.size();
                session.getTransaction().commit();
                factory.close();
                return count;
            }
            case 1:{
                session.beginTransaction();
                List<RegUserDB> us=session.createQuery("from Normal ").getResultList();
                int count=us.size();
                session.getTransaction().commit();
                factory.close();
                return count;
            }
            case 2:{
                session.beginTransaction();
                List<RegUserDB> us=session.createQuery("from Biznes ").getResultList();
                int count=us.size();
                session.getTransaction().commit();
                factory.close();
                return count;
            }
        }
        return 0;
    }

    public int getEco(int id){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Econom.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<Econom> econom= session.createQuery(" from Econom "+"where id='"+id+"'").getResultList();
        int kount=econom.size();
        session.getTransaction().commit();
        factory.close();
        return kount;
    }

    public int getStand(int id){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Normal.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<Econom> econom= session.createQuery(" from Normal "+"where idd='"+id+"'").getResultList();
        int kount=econom.size();
        session.getTransaction().commit();
        factory.close();
        return kount;
    }

    public int getBiznes(int id){
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Biznes.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<Econom> econom= session.createQuery(" from Biznes "+"where id='"+id+"'").getResultList();
        int kount=econom.size();
        session.getTransaction().commit();
        factory.close();
        return kount;
    }
}
