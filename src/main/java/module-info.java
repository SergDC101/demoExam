module com.example.demoexam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.demoexam to javafx.fxml;
    exports com.example.demoexam;
}