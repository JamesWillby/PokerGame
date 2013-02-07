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
}