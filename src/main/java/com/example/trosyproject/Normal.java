package com.example.trosyproject;

import javax.persistence.*;

@Entity
@Table(name="normal",schema = "hotelbooking")
public class Normal {

    @Id
    @Column(name="idd")
    private int idd;

    public Normal() {
    }

    public Normal(int id) {
        this.idd=id;
    }

    public int getId() {
        return idd;
    }

    public void setId(int id) {
        this.idd = idd;
    }

    @Override
    public String toString() {
        return "Normal{" +
                "id=" + idd +
                '}';
    }
}
