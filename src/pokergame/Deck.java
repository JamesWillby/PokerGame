/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;
import java.util.*;
/**
 *
 * @author jameswillby
 */
public class Deck {
    
private Random r = new Random();    
private static String[] suites = {"Clubs","Hearts","Spades","Diamonds"};  
private static int[] values = {0,0,2,3,4,5,6,7,8,9,10,11,12,13,14};
private Vector<Card> deck = null;

public Deck()       
{
        deck = new Vector<Card>(); // initialize the empty vector
        for (int x = 0; x < suites.length;x++)
        for(int y =2;y < values.length;y++)
        deck.add(new Card(suites[x],values[y])); // add the cards of each suite in order
}

public int cardsIntheDeck()
{
        return deck.size();
}

private int generateRandomNumber(int size){ // generates a random number for the shuffling method
       return r.nextInt(size); 
}                                         

public Card returnTheTopCard(){
 Card card = deck.get(deck.size()-1);
 deck.removeElementAt(deck.size()-1); 
 return card;
}

public void shuffleTheCards(){
    if (deck.size() <= 1)
                {System.err.println("Cannot shuffle a deck of 0 or 1 cards");
                System.exit(1);
                }
    else
            {
                for(int x = 0;x < deck.size();x++) //Start at the first card and re-arrange the deck
                {
                     int position1 = generateRandomNumber(deck.size());
                     int position2 = generateRandomNumber(deck.size());
                     Card card1 = deck.get(position1);
                     Card card2 = deck.get(position2);
                     deck.setElementAt(card2, position1);
                     deck.setElementAt(card1, position2);
                }
            }
    
}
}