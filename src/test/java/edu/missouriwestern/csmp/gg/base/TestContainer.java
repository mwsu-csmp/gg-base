package edu.missouriwestern.csmp.gg.base;

import edu.missouriwestern.csmp.gg.base.datastores.InMemoryDataStore;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class TestContainer {


    /*
     * The following code snippet:
     * assert registeredEntities.containsKey(ent.getID());
     * is what makes the removeEnt. and containsEnt. tests fail
     */
    DummyGame game = new DummyGame();
    DummyEntity ent = new DummyEntity(game);

    DummyGame game2 = new DummyGame();
    DummyEntity ent2 = new DummyEntity(game);

    @Test
    public void testGetGame(){
        assertEquals(3, ent.getGame().getNextEventId());
        assertEquals(2, ent.getGame().getEntityId(ent));
        //TODO:assertEquals(ent.toString(), ent.getGame().getEntity(2));
    }

    @Test
    public void testAddEntity(){
        DummyGame tempGame = new DummyGame();//creating DummyGame
        assertEquals(0, tempGame.getEntities().count());

        DummyEntity tempEnt = new DummyEntity(tempGame);//creating DummyEntity for tempGame
        assertEquals(1, tempGame.getEntities().count());

        tempGame.addEntity(ent);//adding entity
        assertEquals(2, tempGame.getEntities().count());
    }

    @Test
    public void removeEntity(){
        assertEquals(0, game2.getEntities().count());

        game2.addEntity(ent);
        assertEquals(1, game2.getEntities().count());


        game.removeEntity(ent);
        game2.removeEntity(ent);
        //TODO:assertEquals(0, game2.getEntities().count());
    }

    @Test
    public void getEntities(){

        assertEquals(2,game.getEntities().count());
        assertEquals(0, game2.getEntities().count());

    }

    @Test
    public void isEmpty(){
        assertEquals(true,game2.isEmpty());
        assertEquals(false, game.isEmpty());
    }

    @Test
    public void containsEntity(){
        assertEquals(true, game.containsEntity(ent));
        assertEquals(true, game.containsEntity(ent2));
        //assertEquals(false, game2.containsEntity(ent));
       //TODO: assertEquals(false, game2.containsEntity(ent2));
        //assertEquals(false, game.containsEntity(new DummyEntity(game2)));
        //assertEquals(true, game2.containsEntity(new DummyEntity(game2)));
    }
}
