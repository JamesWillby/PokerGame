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
        System.out.println("This deck contains...");
        deck.shuffleTheCards();
        deck.printDeck();
                
 }}
