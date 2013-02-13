/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;
import java.util.Vector; 

/**
 *
 * @author jameswillby
 */
public class Referee {
    
    public void evaluateTheHands(Vector<Card> dealer, Vector<Card> player)
    {
        
        
    }
   
      public int FindTheHighCard(Vector<Card> hand) // return the value of the highest ranking card
    {       int highCard = 0;
            for (int x = 0; x < hand.size(); x++) 
            {
                    if (hand.get(x).getValue() > highCard) 
                        highCard = hand.get(x).getValue();
            }
            return highCard;
     }
    public boolean IsThereaStraight(Vector<Card> hand) // examine the hand to see if there is a straight
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
    public boolean IsThereAFlush(Vector <Card> hand){ // examine the hand to see if there's a flush. 
        for (int x = 1; x < hand.size();x++)
        {
            if (!hand.get(x).getSuite().equals(hand.get(x-1).getSuite()))
                return false;
        }
        return true;
    }
    
    public int AreThereSets(Vector<Card> hand) { // looks for sets up to a full house. Returns an integer from 0 - 5         
        Vector<Integer> values = new Vector<Integer>();     
        for(int x = 0;x < hand.size();x++)
        {
           Integer integer = new Integer(hand.get(x).getValue());   // now we determine distinct set values
            if (values.size() == 0) 
            {
                    values.add(integer);
                    continue;
            }
            if (values.contains(integer))
                    continue;
            else values.add(integer);
        }
        
        switch (values.size()) // finally we return an int code for each potential hand
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
             
            case 2: {
                
               for (int x =0; x < hand.size();x++)
               {
               int count = 0; 
               for(int y=0;y < hand.size();y++)
               {
                    if (hand.get(x).getValue() == hand.get(y).getValue())
                        count++;
                    if (count == 4)
                          return 4; // set
               }
               
               
               }
               return 5; // full house
                
            }
                
            default: return 0;  
                
        }   
        }
            
         
    
    
}
