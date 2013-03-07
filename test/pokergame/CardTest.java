package pokergame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pokergame.Card;
import static org.junit.Assert.*;

/**
 *
 * @author jameswillby
 */
public class CardTest {
    
    public CardTest() {
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

    /**
     * Test of setSuite method, of class Card.
     */
    @Test
    public void testSetSuite() {
        System.out.println("setSuite");
        String expectedSuite = "Hearts";
        String actualSuite = "";
        Card instance = new Card("Clubs",3);
        instance.setSuite("Hearts");
        actualSuite = instance.getSuite();
      assertEquals("Not the same suite",actualSuite,expectedSuite);
        
    }

    /**
     * Test of setValue method, of class Card.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int expectedValue = 10;
        int actualValue;
        Card instance = new Card("Clubs",3);
        instance.setValue(10);
        actualValue = instance.getValue();
      assertEquals("Not the same suite",actualValue,expectedValue);
        
    }

    /**
     * Test of getSuite method, of class Card.
     */
    @Test
    public void testGetSuite() {
        System.out.println("getSuite");
        Card instance = new Card("Hearts",10);
        String expResult = "Hearts";
        String result = instance.getSuite();
        assertEquals(expResult, result);
      
    }


    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Card instance = new Card("Hearts",10);
        int expResult = 10;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
}
