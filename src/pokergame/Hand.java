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
 
    private Vector<Card> hand = null;

    Hand() {
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
    
    
    
}
