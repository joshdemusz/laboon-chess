package chessboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by joshdemusz on 10/26/16.
 */
public class GraveyardController implements Initializable
{
    @FXML
    private GridPane virtual_graveyard_black;
    @FXML
    private GridPane virtual_graveyard_white;

    private ArrayList<Piece> logical_graveyard_black;
    private ArrayList<Piece> logical_graveyard_white;

    private int black_count;
    private int white_count;

    private HashMap<Integer, String> piece_images;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        logical_graveyard_black = new ArrayList<Piece>();
        logical_graveyard_white = new ArrayList<Piece>();

        black_count = 0;
        white_count = 0;

        initializePieceImages();
    }

    private void initializePieceImages()
    {
        piece_images = new HashMap<Integer, String>();

        piece_images.put(1, "src/main/resources/Chess_Board/Chess_Pieces/black_king.png");
        piece_images.put(2, "src/main/resources/Chess_Board/Chess_Pieces/black_queen.png");
        piece_images.put(3, "src/main/resources/Chess_Board/Chess_Pieces/black_rook.png");
        piece_images.put(4, "src/main/resources/Chess_Board/Chess_Pieces/black_bishop.png");
        piece_images.put(5, "src/main/resources/Chess_Board/Chess_Pieces/black_knight.png");
        piece_images.put(6, "src/main/resources/Chess_Board/Chess_Pieces/black_pawn.png");

        piece_images.put(7, "src/main/resources/Chess_Board/Chess_Pieces/white-king.png");
        piece_images.put(8, "src/main/resources/Chess_Board/Chess_Pieces/white_queen.png");
        piece_images.put(9, "src/main/resources/Chess_Board/Chess_Pieces/white_rook.png");
        piece_images.put(10, "src/main/resources/Chess_Board/Chess_Pieces/white_bishop.png");
        piece_images.put(11, "src/main/resources/Chess_Board/Chess_Pieces/white-king.png");
        piece_images.put(12, "src/main/resources/Chess_Board/Chess_Pieces/white_pawn.png");

    }

    public void clearGraveyards()
    {
        logical_graveyard_black = new ArrayList<Piece>();
        logical_graveyard_white = new ArrayList<Piece>();

        black_count = 0;
        white_count = 0;

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 2; y++)
            {
                Node rm1 = getNodeFromGridPane(virtual_graveyard_black, y, x);

                if (rm1 instanceof Pane)
                {
                    ((Pane)rm1).getChildren().clear();
                }

                Node rm2 = getNodeFromGridPane(virtual_graveyard_white, y, x);

                if (rm2 instanceof Pane)
                {
                    ((Pane)rm2).getChildren().clear();
                }
            }
        }
    }

    public void removePiece(Piece p)
    {
        if(p.getColor().equalsIgnoreCase("Black"))
        {
            // Get row and column piece should be in graveyard
            int row = black_count/2;
            int col = black_count%2;

            logical_graveyard_black.add(p);
            drawPiece(p, row, col);

            black_count++;
        }
        else if(p.getColor().equalsIgnoreCase("White"))
        {
            // Get row and column piece should be in graveyard
            int row = white_count/2;
            int col = white_count%2;

            logical_graveyard_white.add(p);
            drawPiece(p, row, col);

            white_count++;
        }
    }

    private void drawPiece(Piece p, int x, int y)
    {
        // Get image based from HashMap
        String image_url = piece_images.get(p.getID());

        File file = new File(image_url);
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        // Add image to grid
        if(p.getColor().equalsIgnoreCase("Black"))
        {
            Pane node = (Pane)getNodeFromGridPane(virtual_graveyard_black, y, x);
            node.getChildren().setAll(iv);
        }
        else if(p.getColor().equalsIgnoreCase("White"))
        {
            Pane node = (Pane)getNodeFromGridPane(virtual_graveyard_white, y, x);
            node.getChildren().setAll(iv);
        }
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText(gridPane.getChildren().toString());
        alert.showAndWait();
        for (Node node : gridPane.getChildren())
        {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row)
            {
                return node;
            }
        }
        return null;
    }

    // Allows Chessboard.java to access the methods of chessboard.GraveyardController.java
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
