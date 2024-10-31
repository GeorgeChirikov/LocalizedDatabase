package org.example.localized_database;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedController extends Application {
    @FXML
    private Label select_language, first_name, last_name, email;
    @FXML
    private ChoiceBox language_selector = new ChoiceBox();
    @FXML
    private TextField first_name_input, last_name_input, email_input;
    @FXML
    private Button save_button;

    private ResourceBundle bundle;
    private Locale locale;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LocalizedApplication.class.getResource("localized-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onSaveButtonClick() {
        System.out.println("Save button clicked");
        LocalizationConnection.setLanguage(language_selector.getValue().toString());
        LocalizationConnection.saveData(first_name_input.getText(), last_name_input.getText(), email_input.getText());
    }

    @FXML
    protected void onLanguageSelect() {
        System.out.println("Language selected");
        if (language_selector.getValue().equals("English")) {
            loadLanguage("en", "UK");
        } else if (language_selector.getValue().equals("Japanese")) {
            loadLanguage("ja", "JP");
        } else if (language_selector.getValue().equals("Farsi")) {
            loadLanguage("fa", "IR");
        } else if (language_selector.getValue().equals("French")) {
            loadLanguage("fr", "FR");
        } else if (language_selector.getValue().equals("German")) {
            loadLanguage("de", "DE");
        } else if (language_selector.getValue().equals("Spanish")) {
            loadLanguage("es", "ES");
        } else if (language_selector.getValue().equals("Russian")) {
            loadLanguage("ru", "RU");
        } else if (language_selector.getValue().equals("Swedish")) {
            loadLanguage("sv", "SE");
        } else if (language_selector.getValue().equals("Finnish")) {
            loadLanguage("su", "FI");
        }
    }

    @FXML
    private void loadLanguage(String lang, String country) {
        locale = new Locale(lang, country);
        bundle = ResourceBundle.getBundle("translation", locale);
        select_language.setText(bundle.getString("select_language"));
        first_name.setText(bundle.getString("first_name"));
        last_name.setText(bundle.getString("last_name"));
        email.setText(bundle.getString("email"));
        save_button.setText(bundle.getString("save"));
    }
}