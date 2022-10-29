package com.example.trosyproject;

import javax.persistence.*;

@Entity
@Table(name="econom",schema = "hotelbooking")
public class Econom {

    @Id
    @Column(name="id")
    private int id;

    public Econom() {
    }

    public Econom(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Econom{" +
                "id=" + id +
                '}';
    }
}
