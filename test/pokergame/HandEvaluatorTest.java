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
    public void testAssessFour() 
    {
        int expectedValue = 6;
        int actualValue;
        String suite1 = "Hearts",suite2 = "Clubs";
        Hand testHand = new Hand();
        
        for (int x = 0; x < 5; x++){
        if (x == 2) testHand.add(new Card(suite1,5));
        else testHand.add(new Card(suite2,3));}
        
        actualValue = HandEvaluator.assessHand(testHand);
        assertEquals("Should be 6",expectedValue,actualValue);
        
    }
        @Test   
        public void testAssessFlush()  {
        int expectedValue = 5;
        int actualValue;
        String suite1 = "Hearts";
        Hand testHand = new Hand();
        
        for (int x = 0; x < 5; x++){
        if (x == 1|| x == 2)testHand.add(new Card(suite1,2));
        else testHand.add(new Card(suite1,3));}
        
        actualValue = HandEvaluator.assessHand(testHand);
        assertEquals("Should be 5",expectedValue,actualValue);
        
    }
    
        @Test 
        public void testAssessStraight(){
        
        int expectedValue = 4;
        int actualValue;
        Hand testHand = new Hand();
        
          testHand.add(new Card("Spades",7));
          testHand.add(new Card("Hearts",8));
          testHand.add(new Card("Hearts",9));
          testHand.add(new Card("Hearts",5));
          testHand.add(new Card("Hearts",6));
   
       int x = HandEvaluator.assessHand(testHand);  
       System.out.println(x); 
        actualValue = HandEvaluator.assessHand(testHand);
        assertEquals("Should be 4",expectedValue,actualValue);
        
    }
        
        @Test
        public void testAssessThree(){
            
        int expectedValue = 3;
        int actualValue;
        Hand testHand = new Hand();
        
          testHand.add(new Card("Hearts",3));
          testHand.add(new Card("Hearts",3));
          testHand.add(new Card("Hearts",3));
          testHand.add(new Card("Clubs",2));
          testHand.add(new Card("Spade",1));
       
        actualValue = HandEvaluator.assessHand(testHand);
        assertEquals("Should be 3",expectedValue,actualValue);
        
        }
        
        @Test
        public void testAssessTwoPair(){
        int expectedValue = 2;
        int actualValue;
        
         Hand testHand = new Hand();
        
          testHand.add(new Card("Hearts",3));
          testHand.add(new Card("Spades",3));
          testHand.add(new Card("Hearts",2));
          testHand.add(new Card("Clubs",2));
          testHand.add(new Card("Spade",1));
        
        actualValue = HandEvaluator.assessHand(testHand);
        assertEquals("Should be 2",expectedValue,actualValue);
        
        }
        
        @Test
        public void testAssessPair(){
        int expectedValue = 1;
        int actualValue;
           
        Hand testHand = new Hand();
        
          testHand.add(new Card("Hearts",3));
          testHand.add(new Card("Spades",3));
          testHand.add(new Card("Hearts",7));
          testHand.add(new Card("Clubs",2));
          testHand.add(new Card("Spade",1));
        
        actualValue = HandEvaluator.assessHand(testHand);
        assertEquals("Should be 1",expectedValue,actualValue);
        }
        
        @Test
        public void testAssessHighCard(){
        int expectedValue = 0;
        int actualValue;
      
        Hand testHand = new Hand();
        
          testHand.add(new Card("Hearts",4));
          testHand.add(new Card("Spades",7));
          testHand.add(new Card("Hearts",2));
          testHand.add(new Card("Clubs",3));
          testHand.add(new Card("Spade",1));
        
        actualValue = HandEvaluator.assessHand(testHand);
        assertEquals("Should be 0",expectedValue,actualValue);
        
        }
    
    @Test
    public void testStraight()
    {
        boolean expectedValue = true;
        boolean actualValue;
        String suite1 = "Hearts",suite2 = "Clubs";
        Hand testHand = new Hand();
        for(int x = 1;x <= 5;x++)
        {if (x==2 || x==4) testHand.add(new Card(suite1,x)); 
         else testHand.add(new Card(suite2,x));}
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
    
    @Test
    public void testThree()
    {
        boolean expectedValue = true;
        boolean actualValue;
        Hand testHand = new Hand();
        String suite1 = "Hearts",suite2 = "Clubs";
        for(int x = 1;x <= 5;x++)
        {
         if (x==1) testHand.add(new Card(suite1,2)); 
         if (x==3) testHand.add(new Card(suite1,3)); 
         else testHand.add(new Card(suite2,3));
        }
        actualValue = HandEvaluator.isThereAThree(testHand);
        assertEquals("This is incorrect",expectedValue,actualValue);
    }
    
    @Test
    public void testPair()
    {
      boolean expectedValue = true;
        boolean actualValue;
        Hand testHand = new Hand();
        String suite1 = "Hearts",suite2 = "Clubs";
        for(int x = 1;x <= 5;x++)
        {
         if (x==1||x==3) testHand.add(new Card(suite1,2)); 
         else testHand.add(new Card(suite2,3));
        }
        actualValue = HandEvaluator.isThereAPair(testHand);
        assertEquals("This is incorrect",expectedValue,actualValue);
    }
    
    @Test
    public void testTwoPair()
    {
        boolean expectedValue = true;
        boolean actualValue;
        Hand testHand = new Hand();
     
          testHand.add(new Card("Spade",2));   
          testHand.add(new Card("Hearts",3));
          testHand.add(new Card("Spades",3));
          testHand.add(new Card("Hearts",1));
          testHand.add(new Card("Clubs",2));
    
        actualValue = HandEvaluator.isThereTwoPair(testHand);
        assertEquals("This is incorrect",expectedValue,actualValue);
    }
}
