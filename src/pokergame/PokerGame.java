/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;
import java.util.*;
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
        
       /**
        
        PokerGamePersonFactory personFactory = new PokerGamePersonFactory();
        PokerGamePerson player,dealer,referee; 
        
        player = personFactory.returnPerson("player");
        dealer = personFactory.returnPerson("dealer");
        referee = personFactory.returnPerson("referee");
        
        dealer.shuffleTheDeck();
        
        for (int x=0; x < 5;x++)
        {
            player.takeCard(dealer.dealACard());
            dealer.dealToSelf();
        }
        System.out.println();
        System.out.println(referee.evaluateTheHands(dealer.showHand(),player.showHand()));
       
        
        */
          
        Hand testHanda = new Hand();
        
          testHanda.add(new Card("Hearts",7));
          testHanda.add(new Card("Spades",4));
          testHanda.add(new Card("Hearts",3));
          testHanda.add(new Card("Hearts",2));
          testHanda.add(new Card("Hearts",1));
       
          
        int y = HandEvaluator.assessHand(testHanda);
        
        System.out.println(y);
        
        for (int x=0;x<testHanda.size();x++)
        System.out.println(testHanda.get(x).getSuite() + " " + testHanda.get(x).getValue());
       
                
 }}