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
public class Hand {
 
    protected Vector<Card> hand = null;

    public Hand() {
        this.hand = new Vector<Card>();
    }
    
    
    public void add(Card e)
    {
        hand.add(e);
    }
    
    public void setElementAt(Card c, int position)
    {
    hand.setElementAt(c, position);
    }
    public int size()
    { return hand.size();}
    
    public Card get(int position){
       return hand.get(position);
    }
    
    
    
    boolean matchedCard(Hand otherHand){
        
        for(int x = this.hand.size()-1; x > 0 ;x--)
        {
        for(int y = 0; y < otherHand.size();y++)
        {   
            if(this.hand.get(x).equals(otherHand.get(y)))
                return true;
        }
        }
        return false;
    }
}
