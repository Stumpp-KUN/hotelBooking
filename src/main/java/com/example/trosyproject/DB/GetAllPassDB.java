package com.example.trosyproject.DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GetAllPassDB {

    public ArrayList<String> getAll() throws SQLException{
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<RegUserDB> us=session.createQuery("from RegUserDB ").getResultList();
        ArrayList<String> rn= new ArrayList<>();
        for(int i=0;i<us.size();i++){
            rn.add(us.get(i).getPassword());
        }
        session.getTransaction().commit();
        factory.close();
        return rn;
    }

    public ArrayList<String> getAllEmail() throws SQLException{
        ArrayList<String> rn= new ArrayList<>();
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<RegUserDB> us=session.createQuery("from RegUserDB ").getResultList();
        for(int i=0;i<us.size();i++){
            rn.add(us.get(i).getEmail());
        }
        session.getTransaction().commit();
        factory.close();
        return rn;
   }

    public void alert(String pass) throws SQLException {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("update RegUserDB set alert=true"+" where password='"+pass+"'").executeUpdate();
        session.getTransaction().commit();
        factory.close();
    }

    public String getName(String pass) throws SQLException{
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<RegUserDB> regUserDB= session.createQuery(" from RegUserDB "+"where password='"+pass+"'").getResultList();
        String name=regUserDB.get(0).getName();
        session.getTransaction().commit();
        factory.close();
        return name;
    }

    public String getSurname(String pass) throws SQLException{
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<RegUserDB> regUserDB= session.createQuery("from RegUserDB "+"where password='"+pass+"'").getResultList();
        String surname=regUserDB.get(0).getSurname();
        session.getTransaction().commit();
        factory.close();

        return surname;
    }
    public int getId(String pass) throws SQLException{
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(RegUserDB.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        List<RegUserDB> regUserDB=session.createQuery("from RegUserDB "+"where password='"+pass+"'").getResultList();
        int id=regUserDB.get(0).getId();
        session.getTransaction().commit();
        factory.close();
        return id;
    }
}
