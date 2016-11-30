import chessboard.ChessboardController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainController extends Application
{
    private boolean gameStarted = false;
    private boolean gameSaved = false;
    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        //Platform.setImplicitExit(false); //stops the user from closing with the x in upper right
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
        gameStarted = true;
    }

    public void rotateBoard()
    {
        ChessboardController.getInstance().rotateBoard();
    }

    @FXML
    public void saveGame() //Saves Game if game has been started.
    {
        FileChooser saveChooser = new FileChooser(); //Creates a FileChooser which will use the systems file browser.
        saveChooser.setTitle("Load Game");
        File save = saveChooser.showSaveDialog(new Stage());
        if(save != null){
            try {
                FileWriter fileWriter = new FileWriter(save);
                fileWriter.write(new String("HI!")); //Wil replace this with something actually interesting.
                fileWriter.close();
                gameSaved = true;
            } catch(IOException e){
                System.out.println("Error in saveGame()");
            }
        }
    }

    @FXML
    public void loadGame()
    {
        FileChooser loadChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PGN files (*.pgn)", "*.pgn");
        loadChooser.setTitle("Load Game");
        File load = loadChooser.showOpenDialog(new Stage());
    }

    @FXML
    public void quitGame() throws IOException //Handles the three cases of when a user attempts to quit.
    {
        if(!gameSaved && gameStarted){ //Didnt save before trying to exit.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dialog_Windows/QuitWithoutSaving.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Save before Quitting?");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dialog_Windows/QuitWithSaveOrNoGame.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Save before Quitting?");
            stage.setScene(new Scene(root1));
            stage.show();
            System.exit(0);
        }
    }
}
