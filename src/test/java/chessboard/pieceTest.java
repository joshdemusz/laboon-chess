package chessboard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dsweeney on 10/2/16.
 */
public class pieceTest {

    @Test
    public void getID_test() throws Exception {
    	int testNumber = 4;
    	Piece testPiece = new Piece(testNumber, "white");
    	int resultValue = testPiece.getID();
      Assert.assertEquals((double)testNumber, (double)resultValue,(double)0);
    }

    @Test
    public void getColor_test(){
    	String testColor = new String("White");
    	Piece testPiece = new Piece(0,testColor);
    	String resultString = testPiece.getColor();
    	Assert.assertEquals(testColor,resultString);

    }
    @Test
    public void getIn_play_test1(){
    	boolean testBoolean = true;
    	Piece testPiece = new Piece(0,"Black");
    	testPiece.setIn_play(testBoolean);
    	boolean resultBool = testPiece.getIn_play();
    	Assert.assertEquals(true,resultBool);
    }
    @Test
    public void getIn_play_test2(){
     	boolean testBoolean = false;
    	Piece testPiece = new Piece(0,"Black");
    	testPiece.setIn_play(testBoolean);
    	boolean resultBool = testPiece.getIn_play();
    	Assert.assertEquals(false,resultBool);

    }
    @Test
    public void getLegalMoves_test(){
    	Piece testPiece = new Piece(4,"black");
    	int[][] testArray = testPiece.getLegalMoves();
    	if(testArray.length == 0){
    		Assert.assertFalse(false);
    	}else{
    		Assert.assertTrue(true);
    	}
    }


}
