/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;
import java.util.Vector; 
import static org.mockito.Mockito.*;

/**
 *
 * @author jameswillby
 */
public class Referee implements PokerGamePerson {
    
    @Override
    public String evaluateTheHands(Vector<Card> dealer, Vector<Card> player) // determines which player is winning
    {
      
       boolean player_flush = IsThereAFlush(player); 
       boolean dealer_flush = IsThereAFlush(dealer); 
       boolean player_straight = IsThereAStraight(player); 
       boolean dealer_straight = IsThereAStraight(dealer); 
       int player_set_score = AreThereSets(player);
       int dealer_set_score = AreThereSets(dealer);
       int player_cards_value = sumCardValues(player);
       int dealer_cards_value = sumCardValues(dealer);
       int dealer_high_card = FindTheHighCard(dealer);
       int player_high_card = FindTheHighCard(player);
       
        if (player_straight || dealer_straight)
       {
            if (!player_straight && dealer_straight)
                return "The Dealer is winning";
             if (player_straight && !dealer_straight)
                 return "You are winning";
             else 
             {
                 if (player_cards_value != dealer_cards_value)
                     return (player_cards_value > dealer_cards_value) ? "You are winning" : "The Dealer is winning"; 
                 else return "It's a draw!";
             }
        }
        
           if (player_flush || dealer_flush)
       {
            if (!player_flush && dealer_flush)
                return "The Dealer is winning";
             if (player_flush && !dealer_flush)
                 return "You are winning";
             else 
             {
                 if (player_cards_value != dealer_cards_value)
                     return (player_cards_value > dealer_cards_value) ? "You are winning" : "The Dealer is winning"; 
                 else return "It's a draw!";
             }
        }
       
     if (player_set_score > 0 && dealer_set_score > 0)
     {      
            if (player_set_score != dealer_set_score )
                    return (player_set_score > dealer_set_score) ? "You are winning" : "The Dealer is winning";
            else if (player_set_score == dealer_set_score)
             {
                 if (player_cards_value != dealer_cards_value)
                     return (player_cards_value > dealer_cards_value) ? "You are winning" : "The Dealer is winning"; 
                 else return "It's a draw!";
             }
     }
     
     if (player_high_card == dealer_high_card)
            return "It's a draw";
     
     if (player_high_card > dealer_high_card)
         return "You are winning";
     else return "The Dealer is winning";
     
     
     
     
}   
    
    @Override
      public int FindTheHighCard(Vector<Card> hand) // return the value of the highest ranking card
    {       int highCard = 0;
            for (int x = 0; x < hand.size(); x++) 
            {
                    if (hand.get(x).getValue() > highCard) 
                        highCard = hand.get(x).getValue();
            }
            return highCard;
     }
    @Override
    public boolean IsThereAStraight(Vector<Card> hand) // examine the hand to see if there is a straight
    {
         for(int x = 1;x < hand.size(); x++) // first we set the cards in ascending order
         {
            if(hand.get(x).getValue() < hand.get(x-1).getValue())
            {
                Card card1 = hand.get(x);
                Card card2 = hand.get(x-1);
                hand.setElementAt(card2, x);
                hand.setElementAt(card1, x-1);
            }
         }
         for(int x = 0;x < hand.size()-1; x++) // now we look for a difference of one between sequential cards
         {                                     
                if (hand.get(x).getValue()+1 != hand.get(x+1).getValue()) // if difference is greater than 1, false
                 return false; 
         }
         return true;
    } 
    @Override
    public boolean IsThereAFlush(Vector <Card> hand) // examine the hand to see if there's a flush.
    {  
        for (int x = 1; x < hand.size();x++)
        {
            if (!hand.get(x).getSuite().equals(hand.get(x-1).getSuite()))
                return false;
        }
        return true;
    }
    
    @Override
    public int AreThereSets(Vector<Card> hand) // looks for sets up to a full house. Returns an integer from 0 - 5 
    {         
        Vector<Integer> values = new Vector<Integer>();     
        for(int x = 0;x < hand.size();x++)
        {
           Integer integer = new Integer(hand.get(x).getValue());   // first we determine distinct set values
            if (values.size() == 0) 
            {
                    values.add(integer);
                    continue;
            }
            if (values.contains(integer))
                    continue;
            else values.add(integer);
        }
        
        switch (values.size()) // now we return an int code for each potential hand
        {
            case 5: return 0; // high card
            case 4: return 1; // pair   
            
            case 3: // need to decide if it's two pair or a three
            {
               for (int x =0; x < hand.size();x++)
               {
               int count = 0; 
               for(int y=0;y < hand.size();y++)
               {
                    if (hand.get(x).getValue() == hand.get(y).getValue())
                        count++;
                    if (count == 3)
                          return 3; // three of a kind
               }
               
               
               }
               return 2; // two pair
                
            }
             
            case 2: {  // need to decide if it's four of a kind or a full house
                
               for (int x =0; x < hand.size();x++)
               {
               int count = 0; 
               for(int y=0;y < hand.size();y++)
               {
                    if (hand.get(x).getValue() == hand.get(y).getValue())
                        count++;
                    if (count == 4)
                          return 4; // four of a kind
               }
               
               
               }
               return 5; // full house
                
            }
                
            default: return 0;  // no sets
                
        }   
        }
            
    @Override
 public int sumCardValues(Vector<Card> cr) // return the total of all the cards
    { 
     int sum = 0;
     for (int x =0;x <cr.size();x++)
     {
     sum = sum + cr.get(x).getValue();    
     }
     return sum;
 }

    @Override
    public void takeCard(Card cr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void shuffleTheDeck() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dealToSelf() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToDiscardPile(Card cr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int cardsRemainingInTheDeck() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void printName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Card dealACard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Card throwAwayCard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vector<Card> showHand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
