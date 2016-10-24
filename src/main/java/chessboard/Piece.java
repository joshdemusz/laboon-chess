package chessboard;

/**
 * Created by joshdemusz on 10/22/16.
 */
public class Piece
{
    private String ID;
    private String color;
    private boolean in_play;
    private int x_coord;
    private int y_coord;

    public Piece()
    {
        // Intialize piece information
    }

    public void getLegalMoves()
    {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public int getX_coord() {
        return x_coord;
    }

    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public void setY_coord(int y_coord) {
        this.y_coord = y_coord;
    }
}
