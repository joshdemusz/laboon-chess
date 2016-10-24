package chessboard;/**
 * Created by eksheen on 10/2/16.
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Chessboard
{
    private HashMap<Integer, String> piece_images;

    private Piece logical_board[][];
    private Piece logical_graveyard_black[][];
    private Piece logical_graveyard_white[][];

    @FXML
    private GridPane virtual_board;
    @FXML
    private GridPane virtual_graveyard_black;
    @FXML
    private GridPane virtual_graveyard_white;

    public void newGame()
    {
        initializePieceImages();

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
        initializePieceImages();

        // Set the state of a LOADED GAME

        // User's color

        // Piece locations in board

        // Turn of current player

        // Current graveyards

        // Difficulty (?)

        // Anything else ?

        initializeGame();
    }

    public void initializeGame()
    {

    }

    public void initializePieceImages()
    {
        piece_images = new HashMap<Integer, String>();

        piece_images.put(1, "@Chess_Pieces/black_king.png");
        piece_images.put(2, "@Chess_Pieces/black_queen.png");
        piece_images.put(3, "@Chess_Pieces/black_rook.png");
        piece_images.put(4, "@Chess_Pieces/black_bishop.png");
        piece_images.put(5, "@Chess_Pieces/black_knight.png");
        piece_images.put(6, "@Chess_Pieces/black_pawn.png");

        piece_images.put(7, "@Chess_Pieces/white-king.png");
        piece_images.put(8, "@Chess_Pieces/white_queen.png");
        piece_images.put(9, "@Chess_Pieces/white_rook.png");
        piece_images.put(10, "@Chess_Pieces/white_bishop.png");
        piece_images.put(11, "@Chess_Pieces/white_knight.png");
        piece_images.put(12, "@Chess_Pieces/white_pawn.png");
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
        // Get image based from HashMap
        String image_url = piece_images.get(p.getID());
        Image piece_image = new Image(image_url);

        // Add image to grid
        virtual_board.add(new ImageView(piece_image), p.getX_coord(), p.getY_coord());
    }

    public void removePiece(Piece p)
    {

    }


}
