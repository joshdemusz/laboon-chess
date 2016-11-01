import chessboard.ChessboardController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController extends Application
{
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

    @FXML
    public void startNewGame(ActionEvent actionEvent) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dialog_Windows/NewGameDialog.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Start a New Game");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void rotateBoard()
    {
        ChessboardController.getInstance().rotateBoard();
    }

    public void saveGame()
    {

    }

    public void loadGame()
    {

    }
}
