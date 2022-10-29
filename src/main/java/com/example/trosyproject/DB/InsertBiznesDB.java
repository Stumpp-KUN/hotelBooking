package com.example.trosyproject.DB;

import com.example.trosyproject.Biznes;
import com.example.trosyproject.Econom;
import com.example.trosyproject.Normal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;

public class InsertBiznesDB {




    public void insertBiznes(String name,String surname,String email,String password,int id,int k,int cost) throws SQLException {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).addAnnotatedClass(Econom.class).addAnnotatedClass(Normal.class).addAnnotatedClass(Biznes.class).buildSessionFactory();
        try{
            Session session=factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update RegUserDB set cost='"+cost+"'"+" where password='"+password+"'");
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

        switch (k){
            case 0:{
                SessionFactory factory1=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).addAnnotatedClass(Econom.class).buildSessionFactory();
                Session session=factory1.getCurrentSession();
                session.beginTransaction();
                Econom econom=new Econom(id);
                session.save(econom);
                session.getTransaction().commit();
                session.close();
                factory1.close();
            }
            break;
            case 1:{
                SessionFactory factory1=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).addAnnotatedClass(Normal.class).buildSessionFactory();
                Session session=factory1.getCurrentSession();
                session.beginTransaction();
                Normal normal=new Normal(id);
                session.save(normal);
                session.getTransaction().commit();
                session.close();
                factory1.close();
            }
            break;
            case 2:{
                SessionFactory factory1=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).addAnnotatedClass(Biznes.class).buildSessionFactory();
                Session session=factory1.getCurrentSession();
                session.beginTransaction();
                Biznes biznes=new Biznes(id);
                session.save(biznes);
                session.getTransaction().commit();
                session.close();
                factory1.close();
            }
        }

    }
}
