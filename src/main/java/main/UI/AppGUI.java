package main.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class AppGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader.load()
//        Scene simpleScene = new Scene();
//        Scene advancedScene = new Scene();
        primaryStage.setTitle("The Way");

        //build the simple scene
        Button switchSceneButton = new Button("Advanced View");
        Button startSelectionButton = new Button("Start selecting on map");
        Label waypointCountLabel = new Label();
        waypointCountLabel.setText("blaaa");
        Button selectPointButton = new Button("Select point");
        Button discardPointsButton = new Button("Discard points");
        Button transferButton = new Button("Begin transfer to DCS");
        VBox simpleVbox = new VBox(switchSceneButton, startSelectionButton, waypointCountLabel, selectPointButton, discardPointsButton, transferButton);
        simpleVbox.setAlignment(Pos.CENTER);

        Scene simpleScene = new Scene(simpleVbox);
//        Scene advanced = new Scene();


        primaryStage.setScene(simpleScene);

        primaryStage.show();
    }
}
