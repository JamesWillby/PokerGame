/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;
import java.util.*;
import java.math.*;
/**
 *
 * @author jameswillby
 */
public class Deck {
    
private static String[] suites = {"Clubs","Hearts","Spades","Diamonds"};    
private Vector<Card> deck = null;

public Deck()       
{
   deck = new Vector<Card>();
    for (int x = 0; x < suites.length;x++)
       {
        Vector<Card> cards = new Suite(suites[x]).getCards();
        for (int y = 0; y < cards.size();y++)
        {        
        deck.add(cards.get(y));
        }
       }
}

public void printDeck()
{
for (int x=0; x < deck.size();x++)
    System.out.println("The " + deck.elementAt(x).returnName()
                        + " which has a value of " + deck.elementAt(x).getValue());
}
public int cardsIntheDeck(){return deck.size();}

public int generateRandomNumber(int size)

{
 return (int)(Math.random()*size); // Standard pattern to generate a random number in
}                                                 // the range that we want


public void shuffleTheCards()
{
if (deck.size() <= 1)
    System.err.println("Cannot shuffle a deck of 0 or 1 cards");
else
    {
             for(int x = 0;x < deck.size();x++) //Start at the second card
            {
             int position1 = generateRandomNumber(deck.size()-1);
             int position2 = generateRandomNumber(deck.size()-1);
             Card card1 = deck.get(position1);
             Card card2 = deck.get(position2);
             deck.setElementAt(card2, position1);
             deck.setElementAt(card1, position2);
            }
    }
    
}

}