package chessboard;

import org.junit.Assert;
import org.junit.Test;
import javafx.scene.paint.Color;
/**
 * Created by iwanjek on 10/26/16.
 */
public class chessboardTest {

    @Test
    public void lastTurnColorTest(){
      //tests the getLastTurnColor
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.WHITE;
      cb.setLastTurnColor(color_expected);
      Color color_actual=cb.getLastTurnColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void whiteGetUserColorTest(){
      //tests the getUserColor and setUserColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.WHITE;
      cb.setUserColor(color_expected);
      Color color_actual=cb.getUserColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void blackGetUserColorTest(){
      //tests the getUserColor and setUserColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.BLACK;
      cb.setUserColor(color_expected);
      Color color_actual=cb.getUserColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void whiteGetPCColorTest(){
      //tests the getPcColor and setPcColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.WHITE;
      cb.setPcColor(color_expected);
      Color color_actual=cb.getPcColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void blackGetPcColorTest(){
      //tests the getPcColor and setPcColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.BLACK;
      cb.setPcColor(color_expected);
      Color color_actual=cb.getPcColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void getDifficultyTest(){
      //Tests the getDifficulty and setDifficulty methods
      ChessboardController cb = new ChessboardController();
      String difficulty_expected="easy";
      cb.setDifficulty(difficulty_expected);
      String difficulty_actual=cb.getDifficulty();
      Assert.assertEquals(difficulty_expected,difficulty_actual);
    }

    @Test
    public void trueIsUsersTurnTest(){
      //Tests isUsers_turn and setUsers_turn methods
      ChessboardController cb = new ChessboardController();
      boolean users_turn_expected=true;
      cb.setUsers_turn(users_turn_expected);
      boolean users_turn_actual=cb.isUsers_turn();
      Assert.assertEquals(users_turn_expected,users_turn_actual);
    }

    @Test
    public void falseIsUsersTurnTest(){
      //Tests isUsers_turn and setUsers_turn methods
      ChessboardController cb = new ChessboardController();
      boolean users_turn_expected=false;
      cb.setUsers_turn(users_turn_expected);
      boolean users_turn_actual=cb.isUsers_turn();
      Assert.assertEquals(users_turn_expected,users_turn_actual);
    }

    @Test
    public void getInstanceTest(){
      //Tests ChessboardController and getInstance
      ChessboardController cb = new ChessboardController();
      ChessboardController cb2= new ChessboardController();
      Assert.assertEquals(cb.getInstance(),cb2.getInstance());
    }

    @Test
    public void getRotatedTestTrue(){
      //tests setRotated and isRotated methods
      ChessboardController cb = new ChessboardController();
      boolean rotated = true;
      cb.setRotated(rotated);
      boolean isrotated = cb.isRotated();
      Assert.assertEquals(rotated, isrotated);
    }
    @Test
    public void getRotatedTestFalse(){
      //tests setRotated and isRotated methods
      ChessboardController cb = new ChessboardController();
      boolean rotated = false;
      cb.setRotated(rotated);
      boolean isrotated = cb.isRotated();
      Assert.assertEquals(rotated, isrotated);
    }

}
