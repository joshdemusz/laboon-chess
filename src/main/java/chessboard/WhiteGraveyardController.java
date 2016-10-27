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
public class WhiteGraveyardController extends GraveyardController implements Initializable
{
    @FXML
    private GridPane virtual_graveyard_white;

    private ArrayList<Piece> logical_graveyard_white;

    private int white_count;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        logical_graveyard_white = new ArrayList<Piece>();

        white_count = 0;

        initializePieceImages();
    }

    public void clearGraveyard()
    {
        logical_graveyard_white = new ArrayList<Piece>();

        white_count = 0;

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 2; y++)
            {
                Node rm1 = getNodeFromGridPane(virtual_graveyard_white, y, x);

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
        int row = white_count/2;
        int col = white_count%2;

        logical_graveyard_white.add(p);
        drawPiece(p, row, col);

        white_count++;
    }

    private void drawPiece(Piece p, int x, int y)
    {
        // Get image based from HashMap
        String image_url = piece_images.get(p.getID());

        File file = new File(image_url);
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        // Add image to grid
        Pane node = (Pane)getNodeFromGridPane(virtual_graveyard_white, y, x);
        node.getChildren().setAll(iv);
    }

    private static WhiteGraveyardController instance;
    public WhiteGraveyardController()
    {
        instance = this;
    }
    // static method to get instance of view
    public static WhiteGraveyardController getInstance()
    {
        return instance;
    }
}
