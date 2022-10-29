module com.example.trosyproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires mysql.connector.java;
    requires java.sql;
    requires java.mail;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.example.trosyproject;
    exports com.example.trosyproject;
    exports com.example.trosyproject.mail;
    opens com.example.trosyproject.mail to javafx.fxml;

    exports com.example.trosyproject.DB;
    opens com.example.trosyproject.DB;

}