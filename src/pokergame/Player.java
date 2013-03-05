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

    private Hand cards = null;    
    
    public Player()
    {
        cards = new Hand();
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
    public String evaluateTheHands(Hand dealer, Hand player) {
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

    @Override
    public void addToDiscardPile(Card cr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int cardsRemainingInTheDeck() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Card dealACard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Hand getHand() {
       return cards;
    }
}
