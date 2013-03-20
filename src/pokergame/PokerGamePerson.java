package pokergame;

import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jameswillby
 */
public interface PokerGamePerson {
    
     public void takeCard(Card cr);
     public void evaluateTheHand(Hand player);
     public void shuffleTheDeck();
     public void addToDiscardPile(Card cr);
     public int cardsRemainingInTheDeck();
     public Card dealACard();
     public Card throwAwayCard();
     public Hand getHand();
}
