/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;
import java.util.Vector;
import java.io.*;

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
        Player player = new Player();
        Dealer dealer = new Dealer();
        
        System.out.println();
        System.out.println("And here are our players ...");
        
        System.out.println();
        player.printName();
        dealer.printName();
        System.out.println();
        
        System.out.println("Round one ...");
        System.out.println();
        
        dealer.shuffleTheDeck();
        for(int x = 0;x < 5;x++)
        {
             Card c_r = dealer.dealACard();
             player.takeCard(c_r);           
             dealer.dealToSelf();
        }
        System.out.println();
        System.out.println("There are " + dealer.cardsRemainingInTheDeck() + " cards in the deck");
        System.out.println();
         System.out.println("What does the dealer wish to do?");
         System.out.println();
        
         System.out.println("Dealer inspects their hand");
         System.out.println();
         
        
        
                
 }}
