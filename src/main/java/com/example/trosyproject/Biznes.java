package com.example.trosyproject;

import javax.persistence.*;

@Entity
@Table(name="biznes",schema = "hotelbooking")
public class Biznes {

    @Id
    @Column(name="id")
    private int id;

    public Biznes() {
    }

    public Biznes(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Biznes{" +
                "id=" + id +
                '}';
    }
}
