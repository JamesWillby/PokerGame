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
class Dealer implements Plays {

    private Vector<Card> hand = null;
    private Deck deck = null;
    private Vector<Card> discards = null;
    
    public Dealer(){                // create a new instance and initialises and assigns the deck,                          
        deck = new Deck();          // the dealers hand and the discard pile. 
        hand = new Vector<Card>();
        discards = new Vector<Card>();
    }
    
    public void shuffleTheDeck() {
        deck.shuffleTheCards(); // Dealer shuffles the deck
    }
    
    public Card dealACard() {
        return deck.returnTheTopCard(); // retrieve the top card of the deck
    }
    
    public void dealToSelf() {
        takeCard(dealACard()); // Dealer adds a card to his own hand
    }
   
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
    public void printName() {
        System.out.println("I'm the dealer");
    }
    
    public int cardsRemainingInTheDeck(){
    return deck.cardsIntheDeck();
    }
}