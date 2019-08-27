package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField addressBar;

    @FXML
    WebView web;

    String htLink = "http://";
    String adrsLink;
    WebEngine engine;

    public void go(ActionEvent actionEvent) {
        adrsLink = addressBar.getText();
        engine.load(htLink + adrsLink);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = web.getEngine();
        engine.load(htLink + "www.google.com");

        addressBar.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER){
                adrsLink = addressBar.getText();
                engine.load(htLink + adrsLink);
            }
        });
    }
}