import chessboard.ChessboardController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainController extends Application
{
    @FXML
    private Button quitButton;

    private boolean gameStarted = false;
    private boolean gameSaved = false;
    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Platform.setImplicitExit(false); //stops the user from closing with the x in upper right
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Skeleton.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event){
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                Label label = new Label("Are you sure you want to quit?");

                Button okButton = new Button("Yes");
                okButton.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent actionEvent) {
                        dialog.hide();
                        Platform.exit();
                        System.exit(0);
                    }
                });
                Button cancelButton = new Button("No");
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent actionEvent) {
                        primaryStage.show();
                        dialog.hide();
                        event.consume();
                    }
                });
                FlowPane pane = new FlowPane(10,10);
                pane.setAlignment(Pos.CENTER);
                pane.getChildren().addAll(okButton,cancelButton);
                VBox vBox = new VBox(10);
                vBox.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(label,pane);
                Scene closeScene = new Scene(vBox);
                dialog.setScene(closeScene);
                dialog.showAndWait();
            }
        });
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
        gameStarted = true;
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

    @FXML
    public void saveGame() //Saves Game if game has been started.
    {
        if(!gameStarted){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "There is nothing to save until you you start a new game!");
            alert.setTitle("Alert!");
            alert.setHeaderText("Invalid selection");
            alert.showAndWait();
            return;
        }
        FileChooser saveChooser = new FileChooser(); //Creates a FileChooser which will use the systems file browser.
        saveChooser.setTitle("Save Game");
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
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                Label label = new Label("Are you sure you want to quit?");
                Button okButton = new Button("Yes");
                okButton.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent actionEvent) {
                        dialog.hide();
                        Platform.exit();
                        System.exit(0);
                    }
                });
                Button cancelButton = new Button("No");
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent actionEvent) {
                        Stage stage = (Stage) quitButton.getScene().getWindow();
                        dialog.hide();
                        actionEvent.consume();
                    }
                });
                FlowPane pane = new FlowPane(10,10);
                pane.setAlignment(Pos.CENTER);
                pane.getChildren().addAll(okButton,cancelButton);
                VBox vBox = new VBox(10);
                vBox.setAlignment(Pos.CENTER);
                vBox.getChildren().addAll(label,pane);
                Scene closeScene = new Scene(vBox);
                dialog.setScene(closeScene);
                dialog.showAndWait();
            }
}
