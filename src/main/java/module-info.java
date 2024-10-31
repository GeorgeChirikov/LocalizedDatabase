module org.example.localized_database {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.localized_database to javafx.fxml;
    exports org.example.localized_database;
}