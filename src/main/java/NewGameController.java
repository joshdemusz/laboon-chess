import chessboard.Chessboard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by joshdemusz on 10/23/16.
 */
public class NewGameController
{
    private skeleton main;

    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox chooseColor;
    @FXML
    private ChoiceBox chooseDifficulty;

    private String color;
    private String difficulty;
    private boolean first_or_second;

    @FXML
    private void submitButtonAction() throws IOException
    {
        color = (String) chooseColor.getSelectionModel().getSelectedItem();
        difficulty = (String) chooseDifficulty.getSelectionModel().getSelectedItem();

        if(color.equalsIgnoreCase("Black") || color.equalsIgnoreCase("White"))
        {
            if(difficulty.equalsIgnoreCase("Easy"))
            {
                first_or_second = true;

                // Initialize a new game in Chessboard.java
                Chessboard.getInstance().initializeGame(color, difficulty, first_or_second, true);

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
