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
    private DealerAI dealerBrain = null;

    
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
    public void evaluateTheHand(Hand player){
        dealerBrain =  new DealerAI(player);
        Vector<Card> throwAway = dealerBrain.whichCardsShouldISwap();
        int num = throwAway.size();
        Hand newHand = new Hand();
        for (int y = 0; y < hand.size();y++){
        boolean seen = false;    
        for (int x = 0; x < num;x++) {
          if (throwAway.get(x).equals(hand.get(y)))
              seen = true;
        }
            if (!seen) newHand.add(hand.get(y));
        }
        hand = null;
        for (int x=0; x < num;x++)
        newHand.add(dealACard());
        hand = newHand;
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
    public Hand getHand() {
        return hand;
    }
}