package pokergame;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DealerAITest {
	
	
		
	@Test
	public void test1()  {
		TestHand myhand = new TestHand("highcard"); // dealer AI should choose the last three cards
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		assertEquals("Number of cards wrong", 3, swapcards.size());
		assertEquals("First card wrong", myhand.get(2).getValue(), swapcards.get(0).getValue());	
		assertEquals("Second card wrong", myhand.get(3).getValue(), swapcards.get(1).getValue());	
		assertEquals("Third card wrong", myhand.get(4).getValue(), swapcards.get(2).getValue());	
	
	}
	
		
	@Test
	public void test2() {
		Hand myhand = new TestHand("highcardnearflush"); // dealerAI should choose only the last card
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		assertEquals("Number of cards wrong", 1, swapcards.size());
		assertEquals("Second Card Wrong", swapcards.get(0).getSuite(), myhand.get(4).getSuite());		
	}
	
		
	@Test
	public void test3() {
		Hand myhand = new TestHand("pair"); 
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		assertEquals("wrong number to swap", 3, swapcards.size());
		assertEquals("first swap card wrong", myhand.get(2).getSuite(), swapcards.get(0).getSuite());
		assertEquals("Second card wrong", myhand.get(3).getValue(), swapcards.get(1).getValue());	
		assertEquals("Third card wrong", myhand.get(4).getValue(), swapcards.get(2).getValue());
	}
	
	@Test
	public void test4() {
		Hand myhand = new TestHand("twopair"); 
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		assertEquals("wrong number to swap", 1, swapcards.size());
		assertEquals("first swap card wrong", myhand.get(4).getSuite(), swapcards.get(0).getSuite());
		
	}
	
	@Test
	public void test5() {
		Hand myhand = new TestHand("threeofakind"); 
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		
		assertEquals("wrong number to swap", 2, swapcards.size());
		assertEquals("first swap card wrong", myhand.get(2).getSuite(), swapcards.get(0).getSuite());
		
	}
	
	@Test
	public void test6() {
		Hand myhand = new TestHand("fourofakind"); 
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		assertEquals("wrong number to swap", 0, swapcards.size());
		
		
		
	}
	
	@Test
	public void test7() {
		Hand myhand = new TestHand("flush"); 
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		assertEquals("wrong number to swap", 0, swapcards.size());
		
		
		
	}
	
	@Test
	public void test8() {
		Hand myhand = new TestHand("straight"); 
		
		DealerAI classUnderTest = new DealerAI(myhand);
		Vector<Card> swapcards = classUnderTest.whichCardsShouldISwap();
		
		assertEquals("wrong number to swap", 0, swapcards.size());
		
		
		
	}
}
