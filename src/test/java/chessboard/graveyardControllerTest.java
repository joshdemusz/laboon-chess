package chessboard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by iwanjek on 10/26/16.
 */
public class graveyardControllerTest {
    @Test
    public void getInstance_test(){
        // tests Graveyard Controller and getInstance method
      GraveyardController gc = new GraveyardController();
      GraveyardController gc2 = new GraveyardController();
      Assert.assertEquals(gc.getInstance(),gc2.getInstance());
    }
    @Test
    public void userGraveyard_getInstance_test(){
      //tests UserGraveyardController and getInstance method
      UserGraveyardController ugc = new UserGraveyardController();
      UserGraveyardController ugc2 = new UserGraveyardController();
      Assert.assertEquals(ugc.getInstance(), ugc2.getInstance());
    }
    @Test
    public void pcGraveyard_getInstance_test(){
      //tests UserGraveyardController and getInstance method
      PCGraveyardController pcgc = new PCGraveyardController();
      PCGraveyardController pcgc2 = new PCGraveyardController();
      Assert.assertEquals(pcgc.getInstance(), pcgc2.getInstance());
    }
}
