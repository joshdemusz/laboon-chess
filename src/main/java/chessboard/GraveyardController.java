package chessboard;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.HashMap;

/**
 * Created by joshdemusz on 10/26/16.
 */
public class GraveyardController
{

    protected HashMap<Integer, String> piece_images;

    protected void initializePieceImages()
    {
        piece_images = new HashMap<Integer, String>();

        piece_images.put(1, "src/main/resources/Chess_Board/Chess_Pieces/white-king.png");
        piece_images.put(2, "src/main/resources/Chess_Board/Chess_Pieces/white_queen.png");
        piece_images.put(3, "src/main/resources/Chess_Board/Chess_Pieces/white_rook.png");
        piece_images.put(4, "src/main/resources/Chess_Board/Chess_Pieces/white_bishop.png");
        piece_images.put(5, "src/main/resources/Chess_Board/Chess_Pieces/white_knight.png");
        piece_images.put(6, "src/main/resources/Chess_Board/Chess_Pieces/white_pawn.png");

        piece_images.put(7, "src/main/resources/Chess_Board/Chess_Pieces/white-king.png");
        piece_images.put(8, "src/main/resources/Chess_Board/Chess_Pieces/white_queen.png");
        piece_images.put(9, "src/main/resources/Chess_Board/Chess_Pieces/white_rook.png");
        piece_images.put(10, "src/main/resources/Chess_Board/Chess_Pieces/white_bishop.png");
        piece_images.put(11, "src/main/resources/Chess_Board/Chess_Pieces/white_knight.png");
        piece_images.put(12, "src/main/resources/Chess_Board/Chess_Pieces/white_pawn.png");
    }

    protected Node getNodeFromGridPane(GridPane gridPane, int col, int row)
    {
        for (Node node : gridPane.getChildren())
        {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row)
            {
                return node;
            }
        }
        return null;
    }

    // Allows ChessboardController.java to access the methods of chessboard.GraveyardController.java
    private static GraveyardController instance;
    public GraveyardController()
    {
        instance = this;
    }
    // static method to get instance of view
    public static GraveyardController getInstance()
    {
        return instance;
    }
}
