package chessboard;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by joshdemusz on 10/26/16.
 */
public class UserGraveyardController extends GraveyardController implements Initializable
{
    @FXML
    private GridPane virtual_graveyard_user;

    private ArrayList<Piece> logical_graveyard_user;

    private int user_count;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        logical_graveyard_user = new ArrayList<Piece>();

        user_count = 0;

        initializePieceImages();
    }

    public void clearGraveyard()
    {
        logical_graveyard_user = new ArrayList<Piece>();

        user_count = 0;

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 2; y++)
            {
                Node rm1 = getNodeFromGridPane(virtual_graveyard_user, y, x);

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
        int row = user_count /2;
        int col = user_count %2;

        logical_graveyard_user.add(p);
        drawPiece(p, row, col);

        user_count++;
    }

    private void drawPiece(Piece p, int x, int y)
    {
        // Get image based from HashMap
        String image_url = piece_images.get(p.getID());

        File file = new File(image_url);
        Image image = new Image(file.toURI().toString());

        // Get colored piece that will act as a filter
        WritableImage colored_image = changeImageColor(image, p.getColor());

        ImageView top = new ImageView(image);
        ImageView bottom = new ImageView(colored_image);

        top.setBlendMode(BlendMode.ADD);

        Group blend = new Group(bottom, top);

        BoxBlur bb = new BoxBlur();
        bb.setHeight(10);
        bb.setWidth(10);
        bb.setIterations(3);

        bottom.setEffect(bb);

        Color color = p.getColor();

        top.setMouseTransparent(true);
        bottom.setMouseTransparent(true);
        blend.setMouseTransparent(true);

        // Add image to grid
        Pane node = (Pane)getNodeFromGridPane(virtual_graveyard_user, y, x);
        node.getChildren().setAll(blend);
    }

    public WritableImage changeImageColor(Image i, Color c)
    {
        PixelReader reader = i.getPixelReader();

        int width = (int)i.getWidth();
        int height = (int)i.getHeight();

        WritableImage dest = new WritableImage(width, height);
        PixelWriter writer;
        writer = dest.getPixelWriter();

        // Replace the pixels that are not transparent with the user's color choice
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                if(!reader.getColor(x, y).equals(Color.TRANSPARENT))
                {
                    writer.setColor(x, y, c);
                }
            }
        }

        return dest;
    }


    private static UserGraveyardController instance;
    public UserGraveyardController()
    {
        instance = this;
    }
    // static method to get instance of view
    public static UserGraveyardController getInstance()
    {
        return instance;
    }
}
