import chessboard.ChessboardController;
import chessboard.PCGraveyardController;
import chessboard.UserGraveyardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by joshdemusz on 10/23/16.
 */
public class NewGameController implements Initializable
{
    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;
    @FXML
    private ColorPicker user_colorpicker;
    @FXML
    private ColorPicker pc_colorpicker;
    @FXML
    private ChoiceBox chooseDifficulty;
    @FXML
    private Label startingPlayer;


    private Color userColor;
    private Color pcColor;
    private String difficulty;
    private boolean first_or_second;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        /*if(Math.random() < 0.5)
        {
            first_or_second = true;
            startingPlayer.setText("User");
        }
        else
        {
            first_or_second = false;
            startingPlayer.setText("PC");
        }*/

        // Allow user to always go first for now. PROBABLY CHANGE IN SPRINT 5
        first_or_second = true;
        startingPlayer.setText("User");
    }

    @FXML
    private void changeGoingFirst(ActionEvent event) {
      /*color = (String) chooseColor.getSelectionModel().getSelectedItem();
      if(color.equalsIgnoreCase("Black"))
      {
          startingPlayer.setText("PC");
      }
      if (color.equalsIgnoreCase("White"))
      {
          startingPlayer.setText("User");
      }*/
    }

    @FXML
    private void submitButtonAction() throws IOException
    {
        userColor = user_colorpicker.getValue();
        pcColor = pc_colorpicker.getValue();

        difficulty = (String) chooseDifficulty.getSelectionModel().getSelectedItem();

        if(!(userColor.toString()).equalsIgnoreCase(pcColor.toString()))
        {
            if(difficulty.equalsIgnoreCase("Easy"))
            {
                // Initialize a new game in ChessboardController.java
                ChessboardController.getInstance().initializeGame(userColor, pcColor, difficulty, first_or_second, true);

                // Clear the graveyards
                PCGraveyardController.getInstance().clearGraveyard();
                UserGraveyardController.getInstance().clearGraveyard();

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
