package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    String htLink = "http://";

    @FXML
    TextField addressBar;

    String adrsLink;

    @FXML
    WebView web;

    WebEngine engine;

    public void go(ActionEvent actionEvent) {
        adrsLink = addressBar.getText();
        engine.load(htLink + adrsLink);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = web.getEngine();
        engine.load(htLink + "www.google.com");
    }
}