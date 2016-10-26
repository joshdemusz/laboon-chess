import chessboard.Piece;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * Created by joshdemusz on 10/26/16.
 */
public class GraveyardController
{
    @FXML
    private GridPane virtual_graveyard_black;
    @FXML
    private GridPane virtual_graveyard_white;

    private Piece logical_graveyard_black[][];
    private Piece logical_graveyard_white[][];
}
