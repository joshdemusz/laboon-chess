import chessboard.Chessboard;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * Created by joshdemusz on 10/23/16.
 */
public class NewGameController
{
    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox chooseColor;
    @FXML
    private ChoiceBox chooseDifficulty;

    @FXML
    Chessboard board;

    private String color;
    private String difficulty;
    private boolean first_or_second;

    @FXML
    private void submitButtonAction()
    {
        color = (String) chooseColor.getSelectionModel().getSelectedItem();
        difficulty = (String) chooseDifficulty.getSelectionModel().getSelectedItem();

        if(color.equalsIgnoreCase("Black") || color.equalsIgnoreCase("White"))
        {
            if(difficulty.equalsIgnoreCase("Easy"))
            {

                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();

                //Chessboard game = new Chessboard(color, difficulty, first_or_second, 0);
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
