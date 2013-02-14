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
     public void evaluateTheHands(Vector<Card> dealer, Vector<Card> player);
     public void shuffleTheDeck();
     public int FindTheHighCard(Vector<Card> hand);
     public boolean IsThereAStraight(Vector<Card> hand);
     public boolean IsThereAFlush(Vector <Card> hand);
     public int AreThereSets(Vector<Card> hand);
     public int sumCardValues(Vector<Card> cr);
}
