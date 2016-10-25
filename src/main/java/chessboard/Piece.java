package chessboard;



/**
 * Created by joshdemusz on 10/22/16.
 */
public class Piece
{
    private int ID;
    private String color;
    private boolean in_play;

    public Piece(int id, String c)
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getIn_play() {
        return in_play;
    }

    public void setIn_play(boolean in_play) {
        this.in_play = in_play;
    }
}
