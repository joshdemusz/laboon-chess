package chessboard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by iwanjek on 10/26/16.
 */
public class graveyardControllerTest {
    @Test
    public void getInstance_test(){
      GraveyardController gc = new GraveyardController();
      GraveyardController gc2 = new GraveyardController();

      Assert.assertEquals(gc.getInstance(),gc2.getInstance());
    }

}
