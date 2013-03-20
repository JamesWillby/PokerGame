/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author jameswillby
 */
public abstract class HandEvaluator {

private static int counter = 0;
    
   public static int assessHand(Hand hand) // returns a rank between 0 and 6
   {          
Hand testHand = new Hand();
testHand.add(hand.get(0));
for(int k = 1; k < hand.size(); k++){
testHand.add(hand.get(k));
for(int i = k; i-1 >= 0 ;i--){
if (testHand.get(i).getValue() < testHand.get(i-1).getValue())
{
    Card card1 = testHand.get(i);
    Card card2 = testHand.get(i-1);
    testHand.setElementAt(card2, i);
    testHand.setElementAt(card1, i-1);
}
}
}
      
       boolean straight = isThereAStraight(testHand);
       boolean flush = isThereAFlush(testHand);
       boolean four = isThereAFour(testHand);
       boolean two_pair =isThereTwoPair(testHand);
       boolean three = isThereAThree(testHand);
       boolean pair = isThereAPair(testHand);
       
       if (four) return 6;
       if (flush) return 5;
       if (straight) return 4;
       if (three) return 3;
       if (two_pair) return 2;
       if (pair) return 1;
  
       return 0;
       
    }
    static boolean isThereAStraight(Hand hand){
         for(int x = 0;x < hand.size()-1; x++) // now we look for a difference of one between sequential cards
         {                                     
                if (hand.get(x).getValue()+1 != hand.get(x+1).getValue()) // if difference is greater than 1, false
                return false; 
         }
         return true;
    }

    static boolean isThereAFlush(Hand hand){  
        for (int x = 1; x < hand.size();x++)
        {
            if (!hand.get(x).getSuite().equals(hand.get(x-1).getSuite()))
                return false;
        }
        return true;
    }

    static boolean isThereAFour(Hand hand) {
        for (int z =0; z < hand.size();z++)
        {int count = 0; 
         for(int y=0;y < hand.size();y++)
               {
                    if (hand.get(z).getValue() == hand.get(y).getValue())
                    count++;
                    if (count == 4)
                    return true; // four of a kind
               }}   
   return false;
 }

    static boolean isThereAThree(Hand hand) {
        
        for(int x = 1;x < hand.size(); x++){
        if(hand.get(x).getValue() < hand.get(x-1).getValue())
            {
                Card card1 = hand.get(x);
                Card card2 = hand.get(x-1);
                hand.setElementAt(card2, x);
                hand.setElementAt(card1, x-1);
            }}
         for (int x =0; x < hand.size();x++){
               int count = 0; 
               for(int y=0;y < hand.size();y++)
               {
                    if (hand.get(x).getValue() == hand.get(y).getValue())
                        count++;
                    if (count == 3)
                          return true; // three of a kind
               }}
        return false;
        
    }

    static boolean isThereAPair(Hand hand) {

         for (int x =0; x < hand.size();x++){
               int count = 0; 
               for(int y=0;y < hand.size();y++)
               {
                    if (hand.get(x).getValue() == hand.get(y).getValue())
                        count++;
                    if (count == 2)
                          return true; // a pair
               }}
        return false;
       
    }

    static boolean isThereTwoPair(Hand hand) {
        
        Hand testHand = new Hand();
  
        for (int x = 0; x < hand.size(); x++){
        for (int y = 0; y < hand.size(); y++){
        if (y != x && hand.get(y).getValue() == hand.get(x).getValue())
            testHand.add(hand.get(y));
        }}
        
        if (testHand.size() == 4)
        return true;
        
        else return false;        
    }
    
    static void orderHand(Hand testHand)       
    {
        while (true){
        for (int x = 1; x < testHand.size();x++){
        if (testHand.get(x).getValue() < testHand.get(x-1).getValue())
            {
                 Card card1 = testHand.get(x);
                 Card card2 = testHand.get(x-1);
                 testHand.setElementAt(card2, x);
                 testHand.setElementAt(card1, x-1);
                 
            }
        }
        int count = 0;
        for (int x = 1; x < testHand.size();x++){
        if (testHand.get(x).getValue() < testHand.get(x-1).getValue())
        count++;
        }
        if (count == 0) break;        
      }
    }
    

public static void drawnHand(int rank,PokerGamePerson dealer,PokerGamePerson player)
{
        Hand dealerHand = new Hand();
        dealerHand.add(dealer.getHand().get(0));
        for(int k = 1; k < dealer.getHand().size(); k++){
        dealerHand.add(dealer.getHand().get(k));
        for(int i = k; i-1 >= 0 ;i--){
        if (dealerHand.get(i).getValue() < dealerHand.get(i-1).getValue())
        {
        Card card1 = dealerHand.get(i);
        Card card2 = dealerHand.get(i-1);
        dealerHand.setElementAt(card2, i);
        dealerHand.setElementAt(card1, i-1);
        }
        }
        }
    
        Hand playerHand = new Hand();
        playerHand.add(player.getHand().get(0));
        for(int k = 1; k < player.getHand().size(); k++){
        playerHand.add(player.getHand().get(k));
        for(int i = k; i-1 >= 0 ;i--){
        if (playerHand.get(i).getValue() < playerHand.get(i-1).getValue())
        {   
        Card card1 = playerHand.get(i);
        Card card2 = playerHand.get(i-1);
        playerHand.setElementAt(card2, i);
        playerHand.setElementAt(card1, i-1);
        }
        }
        }
    
        switch(rank)
        {
                case 6:{ 
                     int playerFour = playerHand.get(1).getValue();
                     int dealerFour = dealerHand.get(1).getValue();
                     if (playerFour > dealerFour && counter < 1) System.out.println("You are winning");
                     else if (playerFour > dealerFour && counter >= 1) System.out.println("Congratulations! You beat the Dealer.");
                     else if (playerFour < dealerFour && counter < 1) System.out.println("Dealer is winning.");
                     else System.out.println("The Dealer has won! Bad luck old chap.");
                     counter++;
                     return;
                     }
                case 5:{
                    int playerSum = 0;
                    int dealerSum = 0;
                    for (int x = 0; x < playerHand.size();x++)
                        playerSum = playerSum + playerHand.get(x).getValue();
                    for (int x = 0; x < dealerHand.size();x++)
                        dealerSum = dealerSum + playerHand.get(x).getValue();
                    if (playerSum > dealerSum && counter < 1) System.out.println("You are winning");
                    else if (playerSum > dealerSum && counter >= 1) System.out.println("Congratulations! You beat the Dealer.");
                    else if (playerSum < dealerSum && counter < 1) System.out.println("Dealer is winning");
                    else System.out.println("The Dealer has won! Bad luck old chap.");
                    counter++;
                    return;
                    }
                case 4:{ 
                    int playerSum = 0;
                    int dealerSum = 0;
                    for (int x = 0; x < playerHand.size();x++)
                        playerSum = playerSum + playerHand.get(x).getValue();
                    for (int x = 0; x < dealerHand.size();x++)
                        dealerSum = dealerSum + playerHand.get(x).getValue();
                    if (playerSum > dealerSum && counter < 1) System.out.println("You are winning");
                    else if (playerSum > dealerSum && counter >= 1) System.out.println("Congratulations! You beat the Dealer.");
                    else if (playerSum < dealerSum && counter < 1) System.out.println("Dealer is winning");
                    else System.out.println("The Dealer has won! Bad luck old chap.");
                    counter++;
                    return;
                }
                case 3:{   
                     int playerThree = playerHand.get(2).getValue();
                     int dealerThree = dealerHand.get(2).getValue();
                     if (playerThree > dealerThree && counter < 1) System.out.println("You are winning");
                     else if (playerThree > dealerThree && counter >= 1) System.out.println("Congratulations! You beat the Dealer.");
                     else if (playerThree < dealerThree && counter < 1) System.out.println("Dealer is winning.");
                     else System.out.println("The Dealer has won! Bad luck old chap.");
                     counter++;
                     return;
                }
                case 2:{
                     int playerPairOne = 0, playerPairTwo = 0;
                     int dealerPairOne = 0, dealerPairTwo = 0;
                     
                     for (int x = 0; x <= playerHand.size()-1;x++){
                     for (int y = 0; y <= playerHand.size()-1;y++){
                         if (playerHand.get(y).getValue() == playerHand.get(x).getValue() && x != y)
                             playerPairOne = playerHand.get(y).getValue();
                     }}
                     
                     for (int x = 0; x <= playerHand.size()-1;x++){
                     for (int y = 0; y <= playerHand.size()-1;y++){
                         if (playerHand.get(y).getValue() == playerHand.get(x).getValue() 
                                 && x != y && playerHand.get(y).getValue() != playerPairOne)
                             playerPairTwo = playerHand.get(y).getValue();  
                     }}
                     
                     for (int x = 0; x <= dealerHand.size()-1;x++){
                     for (int y = 0; y <= dealerHand.size()-1;y++){
                         if (dealerHand.get(y).getValue() == dealerHand.get(x).getValue() && x != y)
                             dealerPairOne = dealerHand.get(y).getValue();
                     }}
                     
                     for (int x = 0; x <= dealerHand.size()-1;x++){
                     for (int y = 0; y <= dealerHand.size()-1;y++){
                         if (dealerHand.get(y).getValue() == dealerHand.get(x).getValue() 
                                 && x != y && dealerHand.get(y).getValue() != dealerPairOne)
                             dealerPairTwo = dealerHand.get(y).getValue();  
                     }}
                     
                     if ((playerPairOne + playerPairTwo) > (dealerPairOne + dealerPairTwo) && counter < 1) {
                         System.out.println("You are winning");
                         counter++;
                         return;
                        }
                     else if((playerPairOne + playerPairTwo) > (dealerPairOne + dealerPairTwo) && counter >= 1) {
                         System.out.println("Congratulations! You beat the dealer.");
                         return;
                        } 
                      else if((playerPairOne + playerPairTwo) < (dealerPairOne + dealerPairTwo) && counter < 1) {
                         System.out.println("The Dealer is winning");
                         return;
                        } 
                      else if((playerPairOne + playerPairTwo) < (dealerPairOne + dealerPairTwo) && counter >= 1) {
                         System.out.println("The Dealer has won! Bad luck old chap.");
                         return;
                        } 
                      else {
                      
                     int dealerHigh = 0;
                     int playerHigh = 0;

                     for (int x = 0;x < dealerHand.size();x++){
                     if (dealerHand.get(x).getValue() > dealerHigh)
                     dealerHigh = dealerHand.get(x).getValue();}

                     for (int x = 0;x < playerHand.size();x++){
                     if (playerHand.get(x).getValue() > playerHigh)
                     playerHigh = playerHand.get(x).getValue();}

                     if (playerHigh > dealerHigh && counter < 1) { System.out.println("You are winning"); counter++; return; }
                     else if (playerHigh < dealerHigh && counter < 1) { System.out.println("The Dealer is winning."); counter++; return; }
                     else if (playerHigh > dealerHigh && counter >= 1) { System.out.println("Congratulations! You beat the Dealer."); return; }
                     else if (playerHigh < dealerHigh && counter >= 1) { System.out.println("The Dealer has won! Bad luck old chap."); return; }
                     else System.out.println("It's a draw.");
                     return; }   
                }
                case 1:{ 
                     int dealerPair = 0;
                     int playerPair = 0;
                     
                     for (int x = 0; x <= playerHand.size()-1;x++){
                     for (int y = 0; y <= playerHand.size()-1;y++){
                         if (playerHand.get(y).getValue() == playerHand.get(x).getValue() && x != y)
                             playerPair = playerHand.get(y).getValue();
                     }}
                    
                     for (int x = 0; x <= dealerHand.size()-1;x++){
                     for (int y = 0; y <= dealerHand.size()-1;y++){
                         if (dealerHand.get(y).getValue() == dealerHand.get(x).getValue() && x != y)
                            dealerPair = dealerHand.get(y).getValue();
                     }}
                     
                     if (dealerPair > playerPair && counter < 1) { System.out.println("The Dealer is winning."); counter++; return; }
                     else if (dealerPair > playerPair && counter >= 1) { System.out.println("The Dealer has won! Bad luck old chap."); return; }
                     else if (dealerPair < playerPair && counter < 1) { System.out.println("You are winning"); counter++; return; }
                     else if (playerPair > dealerPair && counter >= 1) { System.out.println("Congratulations! You beat the Dealer."); return;}
                     else
                     {
                     int dealerHigh = 0;
                     int playerHigh = 0;

                     for (int x = 0;x < dealerHand.size();x++){
                     if (dealerHand.get(x).getValue() > dealerHigh)
                     dealerHigh = dealerHand.get(x).getValue();}

                     for (int x = 0;x < playerHand.size();x++){
                     if (playerHand.get(x).getValue() > playerHigh)
                     playerHigh = playerHand.get(x).getValue();}

                     if (playerHigh > dealerHigh && counter < 1) { System.out.println("You are winning"); counter++; return; }
                     else if (playerHigh < dealerHigh && counter < 1) { System.out.println("The Dealer is winning."); counter++; return; }
                     else if (playerHigh > dealerHigh && counter >= 1) { System.out.println("Congratulations! You beat the Dealer."); return; }
                     else if (playerHigh < dealerHigh && counter >= 1) { System.out.println("The Dealer has won! Bad luck old chap."); return; }
                     else System.out.println("It's a draw.");
                     return;                     
                     }
                     
                }
                case 0:{
                     int dealerHigh = 0;
                     int playerHigh = 0;

                     for (int x = 0;x < dealerHand.size();x++){
                     if (dealerHand.get(x).getValue() > dealerHigh)
                     dealerHigh = dealerHand.get(x).getValue();}

                     for (int x = 0;x < playerHand.size();x++){
                     if (playerHand.get(x).getValue() > playerHigh)
                     playerHigh = playerHand.get(x).getValue();}

                     if (playerHigh > dealerHigh && counter < 1) { System.out.println("You are winning"); counter++; return; }
                     else if (playerHigh < dealerHigh && counter < 1) { System.out.println("The Dealer is winning."); counter++; return; }
                     else if (playerHigh > dealerHigh && counter >= 1) { System.out.println("Congratulations! You beat the Dealer."); return; }
                     else if (playerHigh < dealerHigh && counter >= 1) { System.out.println("The Dealer has won! Bad luck old chap."); return; }
                     else System.out.println("It's a draw.");
                     return;   
                }
                }
    
          
}


}
