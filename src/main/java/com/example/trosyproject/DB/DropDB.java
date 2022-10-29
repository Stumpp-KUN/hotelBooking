package com.example.trosyproject.DB;

import com.example.trosyproject.Biznes;
import com.example.trosyproject.Econom;
import com.example.trosyproject.Normal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;

public class DropDB {


    public void dropECO(int id) throws SQLException {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Econom.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery(" delete Econom "+"where id='"+id+"'").executeUpdate();
        session.getTransaction().commit();
        factory.close();
    }

    public void dropNorm(int id) throws SQLException{
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Normal.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery(" delete Normal "+"where id='"+id+"'").executeUpdate();
        session.getTransaction().commit();
        factory.close();
    }

    public void dropBiznes(int id) throws SQLException{
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Biznes.class).buildSessionFactory();
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery(" delete Biznes "+"where id='"+id+"'").executeUpdate();
        session.getTransaction().commit();
        factory.close();
    }

    }

