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
class Dealer implements PokerGamePerson {

    private Hand hand = null;
    private Deck deck = null;
    private Vector<Card> discards = null;

    
    public Dealer(){                // create a new instance and initialises and assigns the deck,                          
        deck = new Deck();          // the dealers hand and the discard pile. 
        hand = new Hand();
        discards = new Vector<Card>();
    }
    @Override
    public void shuffleTheDeck() {
        deck.shuffleTheCards(); // Dealer shuffles the deck
    }
    
    @Override
    public Card dealACard() {
        return deck.returnTheTopCard(); // retrieve the top card of the deck
    }
   
    @Override
    public void addToDiscardPile(Card cr) {  // add a thrown card to the discards
        discards.add(cr);
    }
    
    
    @Override
    public void takeCard(Card cr) { // pick up dealt card and add to the dealer's hand
        hand.add(cr);   
    }

   
    @Override
    public Card throwAwayCard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
    @Override
    public int cardsRemainingInTheDeck(){
    return deck.cardsIntheDeck();
    }

    @Override
    public String evaluateTheHands(Hand dealer, Hand player) {
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
    public Hand getHand() {
        return hand;
    }
}