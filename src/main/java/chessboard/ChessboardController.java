package chessboard;/**
 * Created by eksheen on 10/2/16.
 */

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class ChessboardController implements Initializable
{
	// Game data
	private Color userColor;
	private Color pcColor;
	private Color lastTurnColor;
	private String difficulty;
	private boolean users_turn;
	private int midMove[] = {-1, -1};
	private HashMap<Integer, String> piece_images;
	private boolean rotated;

	// Logical version of the chessboard
	private Piece logical_board[][];

	@FXML
	private GridPane virtual_board;

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

		// Add cells to chessboard
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

		// Add mouse-click listeners for each cell in the chessboard
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

	public void initializeGame(Color uC, Color cC, String d, boolean first_or_second, boolean new_game)
	{
		// Set initial game data
	    setUserColor(uC);
		setPcColor(cC);
		setDifficulty(d);
        setUsers_turn(first_or_second);

        //makes the last color be the one who is not going first.
        if (isUsers_turn())
        {
            setLastTurnColor(cC);
        }
        else
        {
            setLastTurnColor(uC);
        }


        // Anything else ?

        // Set up game
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
		Color user_color = getUserColor();
		Color pc_color = getPcColor();

		// Set up the game
		logical_board = new Piece[8][8];
		Piece w_king = new Piece(7, user_color);
		Piece w_queen = new Piece(8, user_color);
		Piece w_rook1 = new Piece(9, user_color);
		Piece w_rook2 = new Piece(9, user_color);
		Piece w_bishop1 = new Piece(10, user_color);
		Piece w_bishop2 = new Piece(10, user_color);
		Piece w_knight1 = new Piece(11, user_color);
		Piece w_knight2 = new Piece(11, user_color);
		Piece w_pawn1 = new Piece(12, user_color);
		Piece w_pawn2 = new Piece(12, user_color);
		Piece w_pawn3 = new Piece(12, user_color);
		Piece w_pawn4 = new Piece(12, user_color);
		Piece w_pawn5 = new Piece(12, user_color);
		Piece w_pawn6 = new Piece(12, user_color);
		Piece w_pawn7 = new Piece(12, user_color);
		Piece w_pawn8 = new Piece(12, user_color);

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

		Piece b_king = new Piece(1, pc_color);
		Piece b_queen = new Piece(2, pc_color);
		Piece b_rook1 = new Piece(3, pc_color);
		Piece b_rook2 = new Piece(3, pc_color);
		Piece b_bishop1 = new Piece(4, pc_color);
		Piece b_bishop2 = new Piece(4, pc_color);
		Piece b_knight1 = new Piece(5, pc_color);
		Piece b_knight2 = new Piece(5, pc_color);
		Piece b_pawn1 = new Piece(6, pc_color);
		Piece b_pawn2 = new Piece(6, pc_color);
		Piece b_pawn3 = new Piece(6, pc_color);
		Piece b_pawn4 = new Piece(6, pc_color);
		Piece b_pawn5 = new Piece(6, pc_color);
		Piece b_pawn6 = new Piece(6, pc_color);
		Piece b_pawn7 = new Piece(6, pc_color);
		Piece b_pawn8 = new Piece(6, pc_color);

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

        // Draw initial chessboard
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

	// Rotate the chessboard is rotate button is pressed
	public void rotateBoard()
	{
		double rotate_angle = 45;

		if(!isRotated())
		{
			rotate_angle = 180;

			setRotated(true);
		}
		else if(isRotated())
		{
			rotate_angle = 0;

			setRotated(false);
		}

		// Rotate board 180 degress
		virtual_board.setRotate(rotate_angle);

		// Rotate nodes inside the board 180 degrees so they are right-side-up
		for (int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				Node cell = getNodeFromGridPane(virtual_board, y, x);
				cell.setRotate(rotate_angle);
			}
		}

		// Rotate logical board 180 degrees
		for (int i = 0; i < 8 / 2; i++)
		{
			int first = i;
			int last = 7 - i;
			for (int j = first; j < last; j++) {
				int offset = j - first;
				Piece p1 = logical_board[first][j];
				logical_board[first][j] = logical_board[last][last - offset];
				logical_board[last][last - offset] = p1;
				Piece p2 = logical_board[last - offset][first];
				logical_board[last - offset][first] = logical_board[j][last];
				logical_board[j][last] = p2;
			}
		}

		// Rotate turn indicator <once we have one>

	}

	public void movePiece(Piece p, int x1, int y1, int x2, int y2)
	{
        // Move piece if it is allowed
		if(p.getColor() != getLastTurnColor())
		{

			undrawPiece(y1, x1);
			drawPiece(p, y2, x2);
			midMove[0] = -1;
			midMove[1] = -1;
			logical_board[x2][y2] = logical_board[x1][y1];
			logical_board[x1][y1] = null;
			setLastTurnColor(p.getColor());
		}

	}

	// Replace a piece when one piece overtakes another
	//curr is overtaking old piece
	public void replacePiece(Piece old, Piece curr, int x1, int y1, int x2, int y2)
	{

		if(curr.getColor() != getLastTurnColor()){
			undrawPiece(y1, x1);
			undrawPiece(y2, x2);
			drawPiece(curr, y2, x2);
			midMove[0] = -1;
			midMove[1] = -1;
			logical_board[x2][y2] = logical_board[x1][y1];
			logical_board[x1][y1] = null;

			// Add removed piece to graveyard
			/*if(old.getColor().equalsIgnoreCase("Black"))
        {
            PCGraveyardController.getInstance().removePiece(old);
        }
        else if(old.getColor().equalsIgnoreCase("White"))
        {
            UserGraveyardController.getInstance().removePiece(old);
        }*/

			if(old.getColor().equals(getPcColor()))
			{
				PCGraveyardController.getInstance().removePiece(old);
			}
			else if(old.getColor().equals(getUserColor()))
			{
				UserGraveyardController.getInstance().removePiece(old);
			}

			setLastTurnColor(curr.getColor());

		}
	}

	public void removePiece(Piece p, int x, int y)
	{
		// Remove from logical board

		// Add to graveyard of correct color

		// "Undraw" the piece from the GridPane
	}

	// Get locations of chess piece images
	public void initializePieceImages()
	{
		piece_images = new HashMap<Integer, String>();

		piece_images.put(1, "src/main/resources/Chess_Board/Chess_Pieces/white_king.png");
		piece_images.put(2, "src/main/resources/Chess_Board/Chess_Pieces/white_queen.png");
		piece_images.put(3, "src/main/resources/Chess_Board/Chess_Pieces/white_rook.png");
		piece_images.put(4, "src/main/resources/Chess_Board/Chess_Pieces/white_bishop.png");
		piece_images.put(5, "src/main/resources/Chess_Board/Chess_Pieces/white_knight.png");
		piece_images.put(6, "src/main/resources/Chess_Board/Chess_Pieces/white_pawn.png");

		piece_images.put(7, "src/main/resources/Chess_Board/Chess_Pieces/white_king.png");
		piece_images.put(8, "src/main/resources/Chess_Board/Chess_Pieces/white_queen.png");
		piece_images.put(9, "src/main/resources/Chess_Board/Chess_Pieces/white_rook.png");
		piece_images.put(10, "src/main/resources/Chess_Board/Chess_Pieces/white_bishop.png");
		piece_images.put(11, "src/main/resources/Chess_Board/Chess_Pieces/white_knight.png");
		piece_images.put(12, "src/main/resources/Chess_Board/Chess_Pieces/white_pawn.png");
	}

	public void drawBoard()
	{
		// Cycle through logical chessboard
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
				else if (curr == null)
				{
					undrawPiece(y,x);
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

		// Get colored piece that will act as a filter
		WritableImage colored_image = changeImageColor(image, p.getColor());

		ImageView top = new ImageView(image);
		ImageView bottom = new ImageView(colored_image);

		top.setBlendMode(BlendMode.ADD);

		// Blend the chess piece image and its filter
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
		Pane node = (Pane)getNodeFromGridPane(virtual_board, x, y);
		node.getChildren().setAll(blend);
	}

	// Get a colored filter of the chess piece image
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

	// Visually remove a chess piece from the board
	public void undrawPiece(int x, int y)
	{
		Node rm = getNodeFromGridPane(virtual_board, x, y);

		if (rm instanceof Pane)
		{
			((Pane)rm).getChildren().clear();
		}
	}

	// Locate the contents of a cell in the chessboard
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
        //Don't let the user go twice


        if (getUserColor() != getLastTurnColor() && isUsers_turn()) {
            // Swap x/y since rows and columns are flipped in GridPane
            // undrawPiece(y, x);
            //Piece p = new Piece(1, "Black");
            //drawPiece(p, y, x);
            if (logical_board[x][y] == null) {
                //place to move to
                if (midMove[0] != -1 && midMove[1] != -1) {
                    //this is the second click that tells us where to move the piece
                    int initX = midMove[0];
                    int initY = midMove[1];
                    Piece toMove = logical_board[initX][initY];
                    //don't let the user move the computer's pieces

                    if (getUserColor() == toMove.getColor()) {
                        movePiece(toMove, initX, initY, x, y);
                        setUsers_turn(false);
                    }
                }
            } else if ((midMove[0] == -1 && logical_board[x][y].getColor() != getPcColor()) || (logical_board[midMove[0]][midMove[1]].getColor() == logical_board[x][y].getColor() && logical_board[x][y].getColor() != getPcColor())) {
                //Testing ahed when PC makes moves double check if we need the second &&
                //clicked on a piece, and haven't clicked on anything else
                //piece to move
                midMove[0] = x;
                midMove[1] = y;


            } else {
                //trying to overtake other players piece
                int initX = midMove[0];
                int initY = midMove[1];
                Piece ourPiece = logical_board[initX][initY];
                Piece theirPiece = logical_board[x][y];
                //don't let the user move the computer's pieces
                if (getUserColor() == ourPiece.getColor()) {
                    replacePiece(theirPiece, ourPiece, initX, initY, x, y);
                    setUsers_turn(false);
                }
            }
        }
    }

	//*************************************** GETTERS AND SETTERS *******************************************

	public Color getLastTurnColor() {
		return lastTurnColor;
	}

	public void setLastTurnColor(Color lTColor) {
		this.lastTurnColor = lTColor;
	}

	public Color getUserColor() {
		return userColor;
	}

	public void setUserColor(Color userColor) {
		this.userColor = userColor;
	}

	public Color getPcColor() {
		return pcColor;
	}

	public void setPcColor(Color pcColor) {
		this.pcColor = pcColor;
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

	public boolean isRotated() {
		return rotated;
	}

	public void setRotated(boolean rotated) {
		this.rotated = rotated;
	}

	// The following allows NewGameController.java to access ChessboardController.java and call its methods (in particular initializeGame())
	private static ChessboardController instance;
	public ChessboardController()
	{
		instance = this;
	}
	// static method to get instance of view
	public static ChessboardController getInstance()
	{
		return instance;
	}
}
