package chessboard;/**
 * Created by eksheen on 10/2/16.
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Chessboard
{
    private Piece logical_board[][];
    private HashMap<Integer, String> piece_images;

    @FXML
    private GridPane virtual_board;

    public void newGame()
    {
        // Set the state of a NEW GAME

        // User's color

        // Piece locations in board

        // Turn of current player

        // Difficulty (?)

        // Anything else ?

        initializeGame();
    }

    public void loadGame()
    {
        // Set the state of a LOADED GAME

        // User's color

        // Piece locations in board

        // Turn of current player

        // Difficulty (?)

        // Anything else ?

        initializeGame();
    }

    public void initializeGame()
    {

    }

    public void drawBoard()
    {
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                Piece curr = logical_board[x][y];
                drawPiece(curr);
            }
        }
    }

    public void drawPiece(Piece p)
    {
        // Get piece ID

        // Find image file in "piece_images" map

        // Draw the image in the correct "virtual_board" cell
    }


}
