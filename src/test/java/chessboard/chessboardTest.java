package chessboard;

import org.junit.Assert;
import org.junit.Test;
import javafx.scene.paint.Color;
/**
 * Created by iwanjek on 10/26/16.
 */
public class chessboardTest {
    @Test
    public void white_getUserColor_test(){
      //tests the getUserColor and setUserColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.WHITE;
      cb.setUserColor(color_expected);
      Color color_actual=cb.getUserColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void black_getUserColor_test(){
      //tests the getUserColor and setUserColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.BLACK;
      cb.setUserColor(color_expected);
      Color color_actual=cb.getUserColor();
      Assert.assertEquals(color_expected,color_actual);
    }
    
    @Test
    public void white_getPCColor_test(){
      //tests the getPcColor and setPcColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.WHITE;
      cb.setPcColor(color_expected);
      Color color_actual=cb.getPcColor();
      Assert.assertEquals(color_expected,color_actual);
    }
    
    @Test
    public void black_getPCColor_test(){
      //tests the getPcColor and setPcColor methods
      ChessboardController cb = new ChessboardController();
      Color color_expected=Color.BLACK;
      cb.setPcColor(color_expected);
      Color color_actual=cb.getPcColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void getDifficulty_test(){
      //Tests the getDifficulty and setDifficulty methods
      ChessboardController cb = new ChessboardController();
      String difficulty_expected="easy";
      cb.setDifficulty(difficulty_expected);
      String difficulty_actual=cb.getDifficulty();
      Assert.assertEquals(difficulty_expected,difficulty_actual);
    }

    @Test
    public void true_isUsers_turn_test(){
      //Tests isUsers_turn and setUsers_turn methods
      ChessboardController cb = new ChessboardController();
      boolean users_turn_expected=true;
      cb.setUsers_turn(users_turn_expected);
      boolean users_turn_actual=cb.isUsers_turn();
      Assert.assertEquals(users_turn_expected,users_turn_actual);
    }

    @Test
    public void false_isUsers_turn_test(){
      //Tests isUsers_turn and setUsers_turn methods
      ChessboardController cb = new ChessboardController();
      boolean users_turn_expected=false;
      cb.setUsers_turn(users_turn_expected);
      boolean users_turn_actual=cb.isUsers_turn();
      Assert.assertEquals(users_turn_expected,users_turn_actual);
    }

    @Test
    public void getInstance_test(){
      //Tests ChessboardController and getInstance 
      ChessboardController cb = new ChessboardController();
      ChessboardController cb2= new ChessboardController();
      Assert.assertEquals(cb.getInstance(),cb2.getInstance());
    }

    @Test
    public void getRotated_test_true(){
      //tests setRotated and isRotated methods
      ChessboardController cb = new ChessboardController();
      boolean rotated = true;
      cb.setRotated(rotated);
      boolean isrotated = cb.isRotated();
      Assert.assertEquals(rotated, isrotated);
    }
    @Test
    public void getRotated_test_false(){
      //tests setRotated and isRotated methods
      ChessboardController cb = new ChessboardController();
      boolean rotated = false;
      cb.setRotated(rotated);
      boolean isrotated = cb.isRotated();
      Assert.assertEquals(rotated, isrotated);
    }
    
}
