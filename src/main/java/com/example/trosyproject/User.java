package com.example.trosyproject;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private SimpleStringProperty name=new SimpleStringProperty();
    private SimpleStringProperty surname=new SimpleStringProperty();
    private SimpleStringProperty email=new SimpleStringProperty();
    private SimpleIntegerProperty id=new SimpleIntegerProperty();
    private SimpleBooleanProperty alert=new SimpleBooleanProperty();
    private SimpleStringProperty type=new SimpleStringProperty();

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public boolean isAlert() {
        return alert.get();
    }

    public SimpleBooleanProperty alertProperty() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert.set(alert);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setId(int id) {
        this.id.set(id);
    }
}
