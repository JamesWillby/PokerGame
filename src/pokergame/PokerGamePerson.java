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
     public String evaluateTheHands(Vector<Card> dealer, Vector<Card> player); // amend this to modularise
     public void shuffleTheDeck();
     public int FindTheHighCard(Vector<Card> hand);
     public boolean IsThereAStraight(Vector<Card> hand);
     public boolean IsThereAFlush(Vector <Card> hand);
     public int AreThereSets(Vector<Card> hand);
     public int sumCardValues(Vector<Card> cr);
     public void dealToSelf();
     public void addToDiscardPile(Card cr);
     public int cardsRemainingInTheDeck();
     public void printName();
     public Card dealACard();
     public Card throwAwayCard();
     public Vector<Card> showHand();
}
