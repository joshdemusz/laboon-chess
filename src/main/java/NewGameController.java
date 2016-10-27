import chessboard.BlackGraveyardController;
import chessboard.ChessboardController;
import chessboard.WhiteGraveyardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by joshdemusz on 10/23/16.
 */
public class NewGameController implements Initializable
{
    private MainController main;

    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox chooseColor;
    @FXML
    private ChoiceBox chooseDifficulty;
    @FXML
    private Label startingPlayer;

    private String color;
    private String difficulty;
    private boolean first_or_second;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
      color = (String) chooseColor.getSelectionModel().getSelectedItem();
      if(color.equalsIgnoreCase("Black"))
      {
          startingPlayer.setText("PC");
      }
      if (color.equalsIgnoreCase("White"))
      {
          startingPlayer.setText("User");
      }
    }

    @FXML
    private void changeGoingFirst(ActionEvent event) {
      color = (String) chooseColor.getSelectionModel().getSelectedItem();
      if(color.equalsIgnoreCase("Black"))
      {
          startingPlayer.setText("PC");
      }
      if (color.equalsIgnoreCase("White"))
      {
          startingPlayer.setText("User");
      }
    }

    @FXML
    private void submitButtonAction() throws IOException
    {
        color = (String) chooseColor.getSelectionModel().getSelectedItem();
        difficulty = (String) chooseDifficulty.getSelectionModel().getSelectedItem();

        if(color.equalsIgnoreCase("Black") || color.equalsIgnoreCase("White"))
        {
            if(difficulty.equalsIgnoreCase("Easy"))
            {
                // Initialize a new game in ChessboardController.java
                ChessboardController.getInstance().initializeGame(color, difficulty, first_or_second, true);

                // Clear the graveyards
                BlackGraveyardController.getInstance().clearGraveyard();
                WhiteGraveyardController.getInstance().clearGraveyard();

                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
            }
        }
    }

    @FXML
    private void cancelButtonAction()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
