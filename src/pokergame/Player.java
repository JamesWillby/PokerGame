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
class Player implements Plays{

    private Vector<Card> cards = null;    
    
    public Player()
    {
        cards = new Vector<Card>();
    }
    
    @Override
    public void takeCard(Card cr) {
        cards.add(cr);
    }

    @Override
    public Card throwAwayCard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void printName()
    {
    System.out.println("I'm the player");
    }
    
    public Vector<Card> showCards()
    {
       return cards;
    }
}
