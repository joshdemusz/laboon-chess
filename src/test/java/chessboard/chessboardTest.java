package chessboard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by iwanjek on 10/26/16.
 */
public class chessboardTest {
    @Test
    public void white_getColor_test(){

      ChessboardController cb = new ChessboardController();
      String color_expected="white";
      cb.setColor(color_expected);
      String color_actual=cb.getColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void black_getColor_test(){

      ChessboardController cb = new ChessboardController();
      String color_expected="black";
      cb.setColor(color_expected);
      String color_actual=cb.getColor();
      Assert.assertEquals(color_expected,color_actual);
    }

    @Test
    public void getDifficulty_test(){

      ChessboardController cb = new ChessboardController();
      String difficulty_expected="easy";
      cb.setDifficulty(difficulty_expected);
      String difficulty_actual=cb.getDifficulty();
      Assert.assertEquals(difficulty_expected,difficulty_actual);
    }

    @Test
    public void true_isUsers_turn_test(){

      ChessboardController cb = new ChessboardController();
      boolean users_turn_expected=true;
      cb.setUsers_turn(users_turn_expected);
      boolean users_turn_actual=cb.isUsers_turn();
      Assert.assertEquals(users_turn_expected,users_turn_actual);
    }

    @Test
    public void false_isUsers_turn_test(){

      ChessboardController cb = new ChessboardController();
      boolean users_turn_expected=false;
      cb.setUsers_turn(users_turn_expected);
      boolean users_turn_actual=cb.isUsers_turn();
      Assert.assertEquals(users_turn_expected,users_turn_actual);
    }

    @Test
    public void getInstance_test(){

      ChessboardController cb = new ChessboardController();
      ChessboardController cb2= new ChessboardController();
      Assert.assertEquals(cb.getInstance(),cb2.getInstance());
    }



}
