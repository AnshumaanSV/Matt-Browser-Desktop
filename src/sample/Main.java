package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {
    /*
    spaceCount variable keeps the count of input space keys from user.
    spaceCode reads for the input to be a space key.
     */
    SimpleIntegerProperty spaceCount = new SimpleIntegerProperty(0);
    KeyCombination spaceCode = new KeyCodeCombination(KeyCode.SPACE);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
        Load "sample.fxml" and run JavaFX WebEngine.
         */
        Parent browserRoot = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(browserRoot, 1377, 768);

        /*
        Load "VoiceMode.fxml" for user's voice input.
         */
        Parent voiceRoot = FXMLLoader.load(getClass().getResource("VoiceMode.fxml"));
        Scene voiceScene = new Scene(voiceRoot, 1377, 768);

        //Check for spaceCount to exceed 25.
        scene.setOnKeyPressed(ke -> {
            spaceCount.set(spaceCode.match(ke) ? spaceCount.get() + 1 : 0);
            if (spaceCount.getValue().intValue() >= 25) {
                primaryStage.setScene(voiceScene);
            }
        });

        //Reset spaceCount to 0 when space key is released.
        scene.setOnKeyReleased(ke -> {
            if (spaceCode.match(ke)) {
                spaceCount.set(0);
            }
        });

        /*
        Stage properties
        Scene is replaced via VoiceMode when spaceCount exceeds 25.
         */
        primaryStage.setTitle("Matt Browser");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.show();
    }
}