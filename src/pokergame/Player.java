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
class Player implements PokerGamePerson{

    private Vector<Card> cards = null;    
    
    public Player()
    {
        cards = new Vector<Card>();
    }
    
    
    public void takeCard(Card cr) {
        cards.add(cr);
    }

   
    public Card throwAwayCard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void printName()
    {
    System.out.println("I'm the player");
    }
    
    public Vector<Card> showCards()
    {
       return cards;
    }

    @Override
    public void evaluateTheHands(Vector<Card> dealer, Vector<Card> player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void shuffleTheDeck() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int FindTheHighCard(Vector<Card> hand) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean IsThereAStraight(Vector<Card> hand) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean IsThereAFlush(Vector<Card> hand) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int AreThereSets(Vector<Card> hand) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int sumCardValues(Vector<Card> cr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
