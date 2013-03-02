/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

/**
 *
 * @author jameswillby
 */
public abstract class HandEvaluator {

   public static int assessHand(Hand hand) // returns a rank between 0 and 6
   {
      
       boolean straight = isThereAStraight(hand);
       boolean flush = isThereAFlush(hand);
       boolean four = isThereAFour(hand);
       boolean two_pair =isThereTwoPair(hand);
       boolean three = isThereAThree(hand);
       boolean pair = isThereAPair(hand);
       
       if (four) return 6;
       if (flush) return 5;
       if (straight) return 4;
       if (three) return 3;
       if (two_pair) return 2;
       if (pair) return 1;
       
       return 0;
       
    }
    static boolean isThereAStraight(Hand hand)          
    {
    for(int x = 1;x < hand.size(); x++) // first we set the cards in ascending order
         {
            if(hand.get(x).getValue() < hand.get(x-1).getValue())
            {
                Card card1 = hand.get(x);
                Card card2 = hand.get(x-1);
                hand.setElementAt(card2, x);
                hand.setElementAt(card1, x-1);
            }
         }
         for(int x = 0;x < hand.size()-1; x++) // now we look for a difference of one between sequential cards
         {                                     
                if (hand.get(x).getValue()+1 != hand.get(x+1).getValue()) // if difference is greater than 1, false
                return false; 
         }
         return true;
    }

    static boolean isThereAFlush(Hand hand) // examine the hand to see if there's a flush.
    {  
        for (int x = 1; x < hand.size();x++)
        {
            if (!hand.get(x).getSuite().equals(hand.get(x-1).getSuite()))
                return false;
        }
        return true;
    }

 static boolean isThereAFour(Hand hand) 
 {
        
  for(int x = 1;x < hand.size(); x++) // first we set the cards in ascending order
         {
            if(hand.get(x).getValue() < hand.get(x-1).getValue())
            {
                Card card1 = hand.get(x);
                Card card2 = hand.get(x-1);
                hand.setElementAt(card2, x);
                hand.setElementAt(card1, x-1);
            }}
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
                    if (count == 2)
                          return true; // a pair
               }}
        return false;
       
    }

    static boolean isThereTwoPair(Hand hand) {
        
        Hand testHand = new Hand();
        
        for(int x = 1;x < hand.size(); x++){
        if(hand.get(x).getValue() < hand.get(x-1).getValue())
            {
                Card card1 = hand.get(x);
                Card card2 = hand.get(x-1);
                hand.setElementAt(card2, x);
                hand.setElementAt(card1, x-1);
            }}
         
        for (int x = 0; x < hand.size(); x++){
        for (int y = 0; y < hand.size(); y++){
        if (y != x && hand.get(y).getValue() == hand.get(x).getValue())
            testHand.add(hand.get(y));
        }}
        
        if (testHand.size() == 4)
        return true;
        
        else return false;        
    }
    

}
