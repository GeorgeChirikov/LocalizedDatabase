package org.example.localized_database;

public class LocalizedApplication {


    public static void main(String[] args) {
        LocalizationConnection.connect();
        LocalizedController.launch(LocalizedController.class, args);
    }
}