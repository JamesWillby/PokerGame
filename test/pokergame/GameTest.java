/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jameswillby
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void setUpGame() {
        
       int expectedValue = 5;
       int playerValue, dealerValue;
       Game game = new Game();
        
       playerValue = game.getPlayerHand(1).size();
       assertEquals("Not equals",playerValue,expectedValue);
       dealerValue = game.getPlayerHand(0).size();
       assertEquals("Not equals",dealerValue,expectedValue);
     
       Hand dealerHand = game.getPlayerHand(0);
       Hand playerHand = game.getPlayerHand(1);
              
       boolean expectedBool = false;
       boolean actualBool;
       
       actualBool = playerHand.matchedCard(dealerHand);
       
       assertEquals("Not equals",actualBool,expectedBool);
    }
    
    @Test
    public void playGame(){
    
    
    
    
    
}
}
