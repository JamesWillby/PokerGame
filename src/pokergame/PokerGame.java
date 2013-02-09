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
public class PokerGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Deck deck = new Deck();
        System.out.println("Here is our deck ...");
        System.out.println();
        deck.printDeck();
        System.out.println();
        
        System.out.println("Now we shuffle it ...");
        System.out.println();
        deck.shuffleTheCards();
        deck.printDeck();
        
        Plays player = new Participants().returnPlayer("Player");
        Plays dealer = new Participants().returnPlayer("Dealer");
        
        System.out.println();
        System.out.println("And here are our players ...");
        
        System.out.println();
        player.printName();
        dealer.printName();
        System.out.println();
                
 }}
