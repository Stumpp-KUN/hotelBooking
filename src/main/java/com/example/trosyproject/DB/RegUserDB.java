package com.example.trosyproject.DB;

import com.example.trosyproject.Econom;
import com.example.trosyproject.User;

import javax.persistence.*;

import java.sql.*;

@Entity
@Table(name="users",schema = "hotelbooking")
public class RegUserDB{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

@Column(name="name")
    private String name;
@Column(name="surname")
    private String surname;
@Column(name="phone")
    private String phone;
@Column(name="email")
    private String email;
@Column(name="password")
    private String password;
@Column(name="alert")
    private boolean alert;

@Column(name="cost")
    private int cost;


    public RegUserDB(String name, String surname, String phone, String email, String password, boolean alert, int cost) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.alert = alert;
        this.cost = cost;
    }

    public RegUserDB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "RegUserDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", alert=" + alert +
                ", cost=" + cost +
                '}';
    }
}