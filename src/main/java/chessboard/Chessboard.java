package chessboard;/**
 * Created by eksheen on 10/2/16.
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    /*public Chessboard(String color, String difficulty, boolean first_or_second, int new_or_load)
    {
        if(new_or_load == 0)
        {
            //newGame();
        }
        else
        {
            //loadGame();
        }
    }*/

    public void newGame()
    {
        initializePieceImages();

        // Set the state of a NEW GAME

        // User's color
        String user_color = "";

        // Piece locations in board

        // Turn of current player

        // Difficulty (?)

        // Anything else ?

        // Set up the game
        logical_board = new Piece[8][8];
        if(user_color.equalsIgnoreCase("Black"))
        {
            Piece b_king = new Piece(1, "Black");
            Piece b_queen = new Piece(2, "Black");
            Piece b_rook1 = new Piece(3, "Black");
            Piece b_rook2 = new Piece(3, "Black");
            Piece b_bishop1 = new Piece(4, "Black");
            Piece b_bishop2 = new Piece(4, "Black");
            Piece b_knight1 = new Piece(5, "Black");
            Piece b_knight2 = new Piece(5, "Black");
            Piece b_pawn1 = new Piece(6, "Black");
            Piece b_pawn2 = new Piece(6, "Black");
            Piece b_pawn3 = new Piece(6, "Black");
            Piece b_pawn4 = new Piece(6, "Black");
            Piece b_pawn5 = new Piece(6, "Black");
            Piece b_pawn6 = new Piece(6, "Black");
            Piece b_pawn7 = new Piece(6, "Black");
            Piece b_pawn8 = new Piece(6, "Black");

            logical_board[7][3] = b_king;
            logical_board[7][4] = b_queen;
            logical_board[7][0] = b_rook1;
            logical_board[7][7] = b_rook2;
            logical_board[7][2] = b_bishop1;
            logical_board[7][5] = b_bishop2;
            logical_board[7][1] = b_knight1;
            logical_board[7][6] = b_knight2;
            logical_board[6][0] = b_pawn1;
            logical_board[6][1] = b_pawn2;
            logical_board[6][2] = b_pawn3;
            logical_board[6][3] = b_pawn4;
            logical_board[6][4] = b_pawn5;
            logical_board[6][5] = b_pawn6;
            logical_board[6][6] = b_pawn7;
            logical_board[6][7] = b_pawn8;

            Piece w_king = new Piece(7, "White");
            Piece w_queen = new Piece(8, "White");
            Piece w_rook1 = new Piece(9, "White");
            Piece w_rook2 = new Piece(9, "White");
            Piece w_bishop1 = new Piece(10, "White");
            Piece w_bishop2 = new Piece(10, "White");
            Piece w_knight1 = new Piece(11, "White");
            Piece w_knight2 = new Piece(11, "White");
            Piece w_pawn1 = new Piece(12, "White");
            Piece w_pawn2 = new Piece(12, "White");
            Piece w_pawn3 = new Piece(12, "White");
            Piece w_pawn4 = new Piece(12, "White");
            Piece w_pawn5 = new Piece(12, "White");
            Piece w_pawn6 = new Piece(12, "White");
            Piece w_pawn7 = new Piece(12, "White");
            Piece w_pawn8 = new Piece(12, "White");

            logical_board[0][3] = w_king;
            logical_board[0][4] = w_queen;
            logical_board[0][0] = w_rook1;
            logical_board[0][7] = w_rook2;
            logical_board[0][2] = w_bishop1;
            logical_board[0][5] = w_bishop2;
            logical_board[0][1] = w_knight1;
            logical_board[0][6] = w_knight2;
            logical_board[1][0] = w_pawn1;
            logical_board[1][1] = w_pawn2;
            logical_board[1][2] = w_pawn3;
            logical_board[1][3] = w_pawn4;
            logical_board[1][4] = w_pawn5;
            logical_board[1][5] = w_pawn6;
            logical_board[1][6] = w_pawn7;
            logical_board[1][7] = w_pawn8;
        }
        else if(user_color.equalsIgnoreCase("White"))
        {
            Piece w_king = new Piece(1, "White");
            Piece w_queen = new Piece(2, "White");
            Piece w_rook1 = new Piece(3, "White");
            Piece w_rook2 = new Piece(3, "White");
            Piece w_bishop1 = new Piece(4, "White");
            Piece w_bishop2 = new Piece(4, "White");
            Piece w_knight1 = new Piece(5, "White");
            Piece w_knight2 = new Piece(5, "White");
            Piece w_pawn1 = new Piece(6, "White");
            Piece w_pawn2 = new Piece(6, "White");
            Piece w_pawn3 = new Piece(6, "White");
            Piece w_pawn4 = new Piece(6, "White");
            Piece w_pawn5 = new Piece(6, "White");
            Piece w_pawn6 = new Piece(6, "White");
            Piece w_pawn7 = new Piece(6, "White");
            Piece w_pawn8 = new Piece(6, "White");

            logical_board[7][3] = w_king;
            logical_board[7][4] = w_queen;
            logical_board[7][0] = w_rook1;
            logical_board[7][7] = w_rook2;
            logical_board[7][2] = w_bishop1;
            logical_board[7][5] = w_bishop2;
            logical_board[7][1] = w_knight1;
            logical_board[7][6] = w_knight2;
            logical_board[6][0] = w_pawn1;
            logical_board[6][1] = w_pawn2;
            logical_board[6][2] = w_pawn3;
            logical_board[6][3] = w_pawn4;
            logical_board[6][4] = w_pawn5;
            logical_board[6][5] = w_pawn6;
            logical_board[6][6] = w_pawn7;
            logical_board[6][7] = w_pawn8;

            Piece b_king = new Piece(7, "Black");
            Piece b_queen = new Piece(8, "Black");
            Piece b_rook1 = new Piece(9, "Black");
            Piece b_rook2 = new Piece(9, "Black");
            Piece b_bishop1 = new Piece(10, "Black");
            Piece b_bishop2 = new Piece(10, "Black");
            Piece b_knight1 = new Piece(11, "Black");
            Piece b_knight2 = new Piece(11, "Black");
            Piece b_pawn1 = new Piece(12, "Black");
            Piece b_pawn2 = new Piece(12, "Black");
            Piece b_pawn3 = new Piece(12, "Black");
            Piece b_pawn4 = new Piece(12, "Black");
            Piece b_pawn5 = new Piece(12, "Black");
            Piece b_pawn6 = new Piece(12, "Black");
            Piece b_pawn7 = new Piece(12, "Black");
            Piece b_pawn8 = new Piece(12, "Black");

            logical_board[0][3] = b_king;
            logical_board[0][4] = b_queen;
            logical_board[0][0] = b_rook1;
            logical_board[0][7] = b_rook2;
            logical_board[0][2] = b_bishop1;
            logical_board[0][5] = b_bishop2;
            logical_board[0][1] = b_knight1;
            logical_board[0][6] = b_knight2;
            logical_board[1][0] = b_pawn1;
            logical_board[1][1] = b_pawn2;
            logical_board[1][2] = b_pawn3;
            logical_board[1][3] = b_pawn4;
            logical_board[1][4] = b_pawn5;
            logical_board[1][5] = b_pawn6;
            logical_board[1][6] = b_pawn7;
            logical_board[1][7] = b_pawn8;
        }

        //initializeGame();

        drawBoard();
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

        //initializeGame();

        drawBoard();
    }

    public void initializeGame()
    {

    }

    public void movePiece(Piece p, int x1, int y1, int x2, int y2)
    {

    }

    // Replace a piece when one piece overtakes another
    public void replacePiece(Piece old, Piece curr, int x1, int y1, int x2, int y2)
    {

    }

    public void removePiece(Piece p, int x, int y)
    {
        // Remove from logical board

        // Add to graveyard of correct color

        // "Undraw" the piece from the GridPane
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
                drawPiece(curr, x, y);
            }
        }
    }

    public void drawPiece(Piece p, int x, int y)
    {
        // Get image based from HashMap
        String image_url = piece_images.get(p.getID());
        Image piece_image = new Image(image_url);

        // Add image to grid
        virtual_board.add(new ImageView(piece_image), x, y);
    }

    public void undrawPiece(Piece p, int x, int y)
    {
        Node rm = getNodeFromGridPane(virtual_board, x, y);

        virtual_board.getChildren().removeAll(rm);
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row)
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

    @FXML
    private int[] mouseEntered(MouseEvent e)
    {
        Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);

        int coords[] = {rowIndex, colIndex};
        return coords;
    }

}
