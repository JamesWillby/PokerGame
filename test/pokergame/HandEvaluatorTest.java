/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author jameswillby
 */
public class HandEvaluatorTest {
    
    public HandEvaluatorTest() {
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
    public void testAssess() 
    {
        int expectedValue = 2;
        int actualValue;
        Hand mockObject = mock(Hand.class);
        actualValue = HandEvaluator.assessHand(mockObject);
        assertEquals("Not valid",expectedValue,actualValue);
        
    }
   
    @Test
    public void testStraight()
    {
        boolean expectedValue = true;
        boolean actualValue;
        String suite1 = "Hearts",suite2 = "Clubs";
        Hand testHand = new Hand();
        for(int x = 1;x <= 5;x++)
        {
         if (x==2 || x==4) testHand.add(new Card(suite1,x)); 
         else testHand.add(new Card(suite2,x));
        }
        actualValue = HandEvaluator.isThereAStraight(testHand);
        assertEquals("This is incorrect",expectedValue,actualValue);
    }
    
    @Test
    public void testFlush()
    {
        boolean expectedValue = true;
        boolean actualValue;
        String suite1 = "Hearts";
        Hand testHand = new Hand();
        for(int x = 1;x <= 5;x++)
        testHand.add(new Card(suite1,x));
        actualValue = HandEvaluator.isThereAFlush(testHand);
        assertEquals("This is incorrect",expectedValue,actualValue);
        
    }
    
    @Test
    public void testFour()
    {
        boolean expectedValue = true;
        boolean actualValue;
        Hand testHand = new Hand();
        String suite1 = "Hearts",suite2 = "Clubs";
        for(int x = 1;x <= 5;x++)
        {
         if (x==3) testHand.add(new Card(suite1,4)); 
         else testHand.add(new Card(suite2,3));
        }
        actualValue = HandEvaluator.isThereAFour(testHand);
        assertEquals("This is incorrect",expectedValue,actualValue);
    
    
    
    
    }
    
}
