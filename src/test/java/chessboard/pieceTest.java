package chessboard;
import org.junit.Assert;
import org.junit.Test;
import javafx.scene.paint.Color;

/**
 * Created by dsweeney on 10/2/16.
 */
public class pieceTest {
    @Test
    public void getIdTest() throws Exception {
        // tests getID
    	int testNumber = 4;
    	Piece testPiece = new Piece(testNumber, Color.WHITE);
    	int resultValue = testPiece.getID();
      Assert.assertEquals((double)testNumber, (double)resultValue,(double)0);
    }
    @Test
    public void setIdTest(){
        //tests the setID method
        int testNumber = 10;
        int initNumber = 4;
        Piece testPiece = new Piece(4, Color.WHITE);
        testPiece.setID(testNumber);
        int getNum = testPiece.getID();
        Assert.assertEquals(testNumber, getNum);
    }
    @Test
    public void getColorTest(){
        // tests getColor method
    	Color testColor = Color.WHITE;
    	Piece testPiece = new Piece(0,testColor);
    	Color result = testPiece.getColor();
    	Assert.assertEquals(testColor,result);
    }
    @Test
    public void setColorTest(){
        // tests getColor method
        Color initColor = Color.BLACK;
    	Color testColor = Color.WHITE;
    	Piece testPiece = new Piece(0, initColor);
    	testPiece.setColor(testColor);
        Color resultColor = testPiece.getColor();
    	Assert.assertEquals(testColor,resultColor);
    }
    @Test
    public void getInPlayTest1(){
        //tests getIn_play and setIn_play methods
    	boolean testBoolean = true;
    	Piece testPiece = new Piece(0,Color.BLACK);
    	testPiece.setIn_play(testBoolean);
    	boolean resultBool = testPiece.getIn_play();
    	Assert.assertEquals(true,resultBool);
    }
    @Test
    public void getInPlayTest2(){
        //tests getIn_play and setIn_play methods
     	boolean testBoolean = false;
    	Piece testPiece = new Piece(0,Color.BLACK);
    	testPiece.setIn_play(testBoolean);
    	boolean resultBool = testPiece.getIn_play();
    	Assert.assertEquals(false,resultBool);
    }
    /*@Test
    -- getLegalMoves isn't implemented yet
    public void getLegalMoves_test(){
    	Piece testPiece = new Piece(4,Color.BLACK);
    	int[][] testArray = testPiece.getLegalMoves();
    	if(testArray.length == 0){
    		Assert.assertFalse(false);
    	}else{
    		Assert.assertTrue(true);
    	}
    }*/
}
