module EducationalGame {
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.controls;
    requires javafx.web;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.swt;
    requires java.datatransfer;

    opens educational.controller;
    opens educational.model;
    opens educational.scene;
    opens educational.record;
}