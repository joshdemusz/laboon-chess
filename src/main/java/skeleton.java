
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class skeleton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Skeleton.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create a button and place it in the scene
        Scene scene = new Scene(root, 1200, 1200);
        primaryStage.setTitle("laboon-chess"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage

        primaryStage.show(); // Display the stage

        primaryStage.setMaximized(true);
    }
}
