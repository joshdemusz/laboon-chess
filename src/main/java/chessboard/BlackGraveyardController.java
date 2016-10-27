package chessboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by joshdemusz on 10/26/16.
 */
public class BlackGraveyardController extends GraveyardController implements Initializable
{
    @FXML
    private GridPane virtual_graveyard_black;

    private ArrayList<Piece> logical_graveyard_black;

    private int black_count;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        logical_graveyard_black = new ArrayList<Piece>();

        black_count = 0;

        initializePieceImages();
    }

    public void clearGraveyard()
    {
        logical_graveyard_black = new ArrayList<Piece>();

        black_count = 0;

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 2; y++)
            {
                Node rm1 = getNodeFromGridPane(virtual_graveyard_black, y, x);

                if (rm1 instanceof Pane)
                {
                    ((Pane)rm1).getChildren().clear();
                }
            }
        }
    }


    public void removePiece(Piece p)
    {
        // Get row and column piece should be in graveyard
        int row = black_count/2;
        int col = black_count%2;

        logical_graveyard_black.add(p);
        drawPiece(p, row, col);

        black_count++;
    }

    private void drawPiece(Piece p, int x, int y)
    {
        // Get image based from HashMap
        String image_url = piece_images.get(p.getID());

        File file = new File(image_url);
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        // Add image to grid
        Pane node = (Pane)getNodeFromGridPane(virtual_graveyard_black, y, x);
        node.getChildren().setAll(iv);
    }

    private static BlackGraveyardController instance;
    public BlackGraveyardController()
    {
        instance = this;
    }
    // static method to get instance of view
    public static BlackGraveyardController getInstance()
    {
        return instance;
    }
}
