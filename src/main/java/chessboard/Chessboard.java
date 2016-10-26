package chessboard;/**
 * Created by eksheen on 10/2/16.
 */

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class Chessboard implements Initializable
{

    // Game data
    private String color;
    private String difficulty;
    private boolean users_turn;
		private int midMove[] = {-1, -1};
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
    @FXML
    private Pane cell0x0;
    @FXML
    private Pane cell0x1;
    @FXML
    private Pane cell0x2;
    @FXML
    private Pane cell0x3;
    @FXML
    private Pane cell0x4;
    @FXML
    private Pane cell0x5;
    @FXML
    private Pane cell0x6;
    @FXML
    private Pane cell0x7;
    @FXML
    private Pane cell1x0;
    @FXML
    private Pane cell1x1;
    @FXML
    private Pane cell1x2;
    @FXML
    private Pane cell1x3;
    @FXML
    private Pane cell1x4;
    @FXML
    private Pane cell1x5;
    @FXML
    private Pane cell1x6;
    @FXML
    private Pane cell1x7;
    @FXML
    private Pane cell2x0;
    @FXML
    private Pane cell2x1;
    @FXML
    private Pane cell2x2;
    @FXML
    private Pane cell2x3;
    @FXML
    private Pane cell2x4;
    @FXML
    private Pane cell2x5;
    @FXML
    private Pane cell2x6;
    @FXML
    private Pane cell2x7;
    @FXML
    private Pane cell3x0;
    @FXML
    private Pane cell3x1;
    @FXML
    private Pane cell3x2;
    @FXML
    private Pane cell3x3;
    @FXML
    private Pane cell3x4;
    @FXML
    private Pane cell3x5;
    @FXML
    private Pane cell3x6;
    @FXML
    private Pane cell3x7;
    @FXML
    private Pane cell4x0;
    @FXML
    private Pane cell4x1;
    @FXML
    private Pane cell4x2;
    @FXML
    private Pane cell4x3;
    @FXML
    private Pane cell4x4;
    @FXML
    private Pane cell4x5;
    @FXML
    private Pane cell4x6;
    @FXML
    private Pane cell4x7;
    @FXML
    private Pane cell5x0;
    @FXML
    private Pane cell5x1;
    @FXML
    private Pane cell5x2;
    @FXML
    private Pane cell5x3;
    @FXML
    private Pane cell5x4;
    @FXML
    private Pane cell5x5;
    @FXML
    private Pane cell5x6;
    @FXML
    private Pane cell5x7;
    @FXML
    private Pane cell6x0;
    @FXML
    private Pane cell6x1;
    @FXML
    private Pane cell6x2;
    @FXML
    private Pane cell6x3;
    @FXML
    private Pane cell6x4;
    @FXML
    private Pane cell6x5;
    @FXML
    private Pane cell6x6;
    @FXML
    private Pane cell6x7;
    @FXML
    private Pane cell7x0;
    @FXML
    private Pane cell7x1;
    @FXML
    private Pane cell7x2;
    @FXML
    private Pane cell7x3;
    @FXML
    private Pane cell7x4;
    @FXML
    private Pane cell7x5;
    @FXML
    private Pane cell7x6;
    @FXML
    private Pane cell7x7;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // Create HashMap of piece ID --> image url
        initializePieceImages();

        ArrayList<Pane> cells = new ArrayList<Pane>();

        cells.add(cell0x0);
        cells.add(cell0x1);
        cells.add(cell0x2);
        cells.add(cell0x3);
        cells.add(cell0x4);
        cells.add(cell0x5);
        cells.add(cell0x6);
        cells.add(cell0x7);
        cells.add(cell1x0);
        cells.add(cell1x1);
        cells.add(cell1x2);
        cells.add(cell1x3);
        cells.add(cell1x4);
        cells.add(cell1x5);
        cells.add(cell1x6);
        cells.add(cell1x7);
        cells.add(cell2x0);
        cells.add(cell2x1);
        cells.add(cell2x2);
        cells.add(cell2x3);
        cells.add(cell2x4);
        cells.add(cell2x5);
        cells.add(cell2x6);
        cells.add(cell2x7);
        cells.add(cell3x0);
        cells.add(cell3x1);
        cells.add(cell3x2);
        cells.add(cell3x3);
        cells.add(cell3x4);
        cells.add(cell3x5);
        cells.add(cell3x6);
        cells.add(cell3x7);
        cells.add(cell4x0);
        cells.add(cell4x1);
        cells.add(cell4x2);
        cells.add(cell4x3);
        cells.add(cell4x4);
        cells.add(cell4x5);
        cells.add(cell4x6);
        cells.add(cell4x7);
        cells.add(cell5x0);
        cells.add(cell5x1);
        cells.add(cell5x2);
        cells.add(cell5x3);
        cells.add(cell5x4);
        cells.add(cell5x5);
        cells.add(cell5x6);
        cells.add(cell5x7);
        cells.add(cell6x0);
        cells.add(cell6x1);
        cells.add(cell6x2);
        cells.add(cell6x3);
        cells.add(cell6x4);
        cells.add(cell6x5);
        cells.add(cell6x6);
        cells.add(cell6x7);
        cells.add(cell7x0);
        cells.add(cell7x1);
        cells.add(cell7x2);
        cells.add(cell7x3);
        cells.add(cell7x4);
        cells.add(cell7x5);
        cells.add(cell7x6);
        cells.add(cell7x7);

        cell0x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 0);
            }
        });
        cell0x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 1);
            }
        });
        cell0x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 2);
            }
        });
        cell0x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 3);
            }
        });
        cell0x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 4);
            }
        });
        cell0x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 5);
            }
        });
        cell0x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 6);
            }
        });
        cell0x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(0, 7);
            }
        });
        cell1x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 0);
            }
        });
        cell1x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 1);
            }
        });
        cell1x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 2);
            }
        });
        cell1x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 3);
            }
        });
        cell1x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 4);
            }
        });
        cell1x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 5);
            }
        });
        cell1x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 6);
            }
        });
        cell1x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(1, 7);
            }
        });
        cell2x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 0);
            }
        });
        cell2x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 1);
            }
        });
        cell2x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 2);
            }
        });
        cell2x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 3);
            }
        });
        cell2x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 4);
            }
        });
        cell2x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 5);
            }
        });
        cell2x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 6);
            }
        });
        cell2x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(2, 7);
            }
        });
        cell3x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 0);
            }
        });
        cell3x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 1);
            }
        });
        cell3x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 2);
            }
        });
        cell3x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 3);
            }
        });
        cell3x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 4);
            }
        });
        cell3x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 5);
            }
        });
        cell3x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 6);
            }
        });
        cell3x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(3, 7);
            }
        });
        cell4x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 0);
            }
        });
        cell4x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 1);
            }
        });
        cell4x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 2);
            }
        });
        cell4x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 3);
            }
        });
        cell4x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 4);
            }
        });
        cell4x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 5);
            }
        });
        cell4x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 6);
            }
        });
        cell4x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(4, 7);
            }
        });
        cell5x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 0);
            }
        });
        cell5x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 1);
            }
        });
        cell5x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 2);
            }
        });
        cell5x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 3);
            }
        });
        cell5x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 4);
            }
        });
        cell5x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 5);
            }
        });
        cell5x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 6);
            }
        });
        cell5x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(5, 7);
            }
        });
        cell6x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 0);
            }
        });
        cell6x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 1);
            }
        });
        cell6x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 2);
            }
        });
        cell6x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 3);
            }
        });
        cell6x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 4);
            }
        });
        cell6x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 5);
            }
        });
        cell6x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 6);
            }
        });
        cell6x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(6, 7);
            }
        });
        cell7x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 0);
            }
        });
        cell7x1.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 1);
            }
        });
        cell7x2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 2);
            }
        });
        cell7x3.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 3);
            }
        });
        cell7x4.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 4);
            }
        });
        cell7x5.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 5);
            }
        });
        cell7x6.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 6);
            }
        });
        cell7x7.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                clickSpace(7, 7);
            }
        });

        /*cell0x0.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent e)
            {
                        //virtual_board.getChildren().clear();
                        undrawPiece(0, 0);
            }
        });*/
    }

    public void initializeGame(String c, String d, boolean first_or_second, boolean new_game)
    {
        setColor(c);
        setDifficulty(d);
        setUsers_turn(!first_or_second);


        // Anything else ?

        if(new_game)
        {
            newGame();
        }
        else
        {
            loadGame();
        }
    }

    // Set the state of a NEW GAME
    public void newGame()
    {
        // User's color
        String user_color = getColor();

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

            logical_board[7][4] = b_king;
            logical_board[7][3] = b_queen;
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

            logical_board[0][4] = w_king;
            logical_board[0][3] = w_queen;
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

            logical_board[7][4] = w_king;
            logical_board[7][3] = w_queen;
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

            logical_board[0][4] = b_king;
            logical_board[0][3] = b_queen;
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

    public void movePiece(Piece p, int x1, int y1, int x2, int y2)
    {
			undrawPiece(y1, x1);
			drawPiece(p, y2, x2);
			midMove[0] = -1;
			midMove[1] = -1;
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

    public void drawBoard()
    {
        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                // Flip x/y because rows and cols are flipped in GridPane
                Piece curr = logical_board[x][y];

                if(curr != null)
                {
                    // Clear cell before adding a new piece
                    undrawPiece(y, x);
                    // Draw the current piece
                    drawPiece(curr, y, x);
                }
            }
        }
    }

    public void drawPiece(Piece p, int x, int y)
    {
        // Get image based from HashMap
        String image_url = piece_images.get(p.getID());

        File file = new File(image_url);
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        iv.setMouseTransparent(true);

        // Add image to grid
        Pane node = (Pane)getNodeFromGridPane(virtual_board, x, y);
        node.getChildren().setAll(iv);
    }

    public void undrawPiece(int x, int y)
    {
        Node rm = getNodeFromGridPane(virtual_board, x, y);

        if (rm instanceof Pane)
        {
            ((Pane)rm).getChildren().clear();
        }
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

    public void clickSpace(int x, int y)
    {
        // Swap x/y since rows and columns are flipped in GridPane
        // undrawPiece(y, x);
        //Piece p = new Piece(1, "Black");
        //drawPiece(p, y, x);
				if(logical_board[x][y] == null){
					//place to move to
					if(midMove[0] != -1 && midMove[1] != -1){
						//this is the second click that tells us where to move the piece
						int initX = midMove[0];
						int initY = midMove[1];
						Piece toMove = logical_board[initX][initY];
						movePiece(toMove, initX, initY, x, y);
					}
				}else{
					//piece to move
					midMove[0] = x;
					midMove[1] = y;
				}
    }

    //*************************************** GETTERS AND SETTERS *******************************************
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isUsers_turn() {
        return users_turn;
    }

    public void setUsers_turn(boolean users_turn) {
        this.users_turn = users_turn;
    }

    // The following allows NewGameController.java to access Chessboard.java and call its methods (in particular initializeGame())
    private static Chessboard instance;
    public Chessboard() {
        instance = this;
    }
    // static method to get instance of view
    public static Chessboard getInstance() {
        return instance;
    }
}
