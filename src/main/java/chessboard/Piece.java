package chessboard;


import javafx.scene.paint.Color;

/**
 * Created by joshdemusz on 10/22/16.
 */
public class Piece
{
    private int ID;
    private Color color;
    private boolean in_play;

    public Piece(int id, Color c)
    {
        // Intialize piece information
        setID(id);
        setColor(c);
    }

    public void getLegalMoves()
    {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getIn_play() {
        return in_play;
    }

    public void setIn_play(boolean in_play) {
        this.in_play = in_play;
    }
}
