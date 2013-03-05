package pokergame;

import java.util.Vector;


public class TestHand extends Hand{

	
	
	public TestHand(String handtype) {
    	
            
            
	    if (handtype.equals("highcard")){
	    Card card1 = new Card("Hearts", 4);
		Card card2 = new Card("Hearts", 12);
		Card card3 = new Card("Diamonds", 11);
		Card card4 = new Card("Spades", 10);
		Card card5 = new Card("Clubs", 2);
		
			
		
		hand.add(0, card1);
		hand.add(1, card2);
		hand.add(2, card3);
		hand.add(3, card4);
		hand.add(4, card5);
	    }
	    
	    
	    
	    if (handtype.equals("highcardnearflush")){
	        Card card1 = new Card("Hearts", 14);
	    	Card card2 = new Card("Hearts", 13);
	    	Card card3 = new Card("Hearts", 2);
	    	Card card4 = new Card("Hearts", 3);
	    	Card card5 = new Card("Clubs", 4);
	    	
	    		
	    	
	    	hand.add(card1);
	    	hand.add(card2);
	    	hand.add(card3);
	    	hand.add(card4);
	    	hand.add(card5);
	        }
	    
	    if (handtype.equals("pair")){
	        Card card1 = new Card("Hearts", 6);
	    	Card card2 = new Card("Diamonds", 6);
	    	Card card3 = new Card("Diamonds", 3);
	    	Card card4 = new Card("Spades", 11);
	    	Card card5 = new Card("Clubs", 8);
	    	
	    		
	    	
	    	hand.add(0, card1);
	    	hand.add(1, card2);
	    	hand.add(2, card3);
	    	hand.add(3, card4);
	    	hand.add(4, card5);
	        }
	    
	    if (handtype.equals("threeofakind")){
	        Card card1 = new Card("Hearts", 6);
	    	Card card2 = new Card("Diamonds", 6);
	    	Card card3 = new Card("Clubs", 3);
	    	Card card4 = new Card("Spades", 6);
	    	Card card5 = new Card("Spades", 8);
	    	
	    		
	    	
	    	hand.add(0, card1);
	    	hand.add(1, card2);
	    	hand.add(2, card3);
	    	hand.add(3, card4);
	    	hand.add(4, card5);
	        }
	    
	    if (handtype.equals("twopair")){
	        Card card1 = new Card("Hearts", 6);
	    	Card card2 = new Card("Diamonds", 6);
	    	Card card3 = new Card("Diamonds", 3);
	    	Card card4 = new Card("Spades", 3);
	    	Card card5 = new Card("Clubs", 8);
	    	
	    		
	    	
	    	hand.add(0, card1);
	    	hand.add(1, card2);
	    	hand.add(2, card3);
	    	hand.add(3, card4);
	    	hand.add(4, card5);
	        }
	    
	    if (handtype.equals("straight")){
	        Card card1 = new Card("Hearts", 5);
	    	Card card2 = new Card("Diamonds", 2);
	    	Card card3 = new Card("Diamonds", 3);
	    	Card card4 = new Card("Spades", 4);
	    	Card card5 = new Card("Clubs", 1);
	    	
	    		
	    	
	    	hand.add(0, card1);
	    	hand.add(1, card2);
	    	hand.add(2, card3);
	    	hand.add(3, card4);
	    	hand.add(4, card5);
	        }
	    
	    if (handtype.equals("flush")){
	        Card card1 = new Card("Hearts", 6);
	    	Card card2 = new Card("Hearts", 2);
	    	Card card3 = new Card("Hearts", 3);
	    	Card card4 = new Card("Hearts", 11);
	    	Card card5 = new Card("Hearts", 8);
	    	
	    		
	    	
	    	hand.add(0, card1);
	    	hand.add(1, card2);
	    	hand.add(2, card3);
	    	hand.add(3, card4);
	    	hand.add(4, card5);
	        }
	    
	    if (handtype.equals("fourofakind")){
	        Card card1 = new Card("Hearts", 6);
	    	Card card2 = new Card("Diamonds", 6);
	    	Card card3 = new Card("Spades", 6);
	    	Card card4 = new Card("Clubs", 6);
	    	Card card5 = new Card("Hearts", 8);
	    	
	    		
	    	
	    	hand.add(0, card1);
	    	hand.add(1, card2);
	    	hand.add(2, card3);
	    	hand.add(3, card4);
	    	hand.add(4, card5);
	        }
	    
	    
	    
	    }

}
