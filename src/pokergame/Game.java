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
public class Game {
    
    private Vector<PokerGamePerson> players;
    
    public Game()
    {
        this(2);
    }
    
    public Game(int x)
    {
       if (x > 6 || x < 2) 
        {   System.err.println ("Forbidden number of players");
            System.exit(1);
        }
       
        players = new Vector<PokerGamePerson>();
        PokerGamePersonFactory personFactory = new PokerGamePersonFactory();
        PokerGamePerson dealer = personFactory.returnPerson("dealer");
        players.add(dealer);
        
        
        for (int y = 1; y < x;y++)
        {
        PokerGamePerson player = personFactory.returnPerson("player");
        players.add(player);
        }
        
        dealer.shuffleTheDeck(); // shuffles deck
        
        //deals 5 cards to player and dealer
        
        for (int z=0; z < 5;z++)
        {
            for (int y = players.size()-1;y >= 0;y--)
            {
            players.get(y).takeCard(players.get(0).dealACard());
            }
        }
    }
    
    public void run(){
        
       if (HandEvaluator.assessHand(players.get(0).getHand()) > HandEvaluator.assessHand(players.get(1).getHand()))
       {
       System.out.println("The Dealer is winning");}
       else if (HandEvaluator.assessHand(players.get(0).getHand()) < HandEvaluator.assessHand(players.get(1).getHand()))
       {
       System.out.println("You are winning");
       }
       else HandEvaluator.drawnHand(
                                    HandEvaluator.assessHand(players.get(0).getHand()), 
                                    players.get(0), 
                                    players.get(1)); 
             
        System.out.println();
        
        for (int x = players.size()-1; x >= 1; x--){
        players.get(x).evaluateTheHand(players.get(x).getHand());
        int number = players.get(x).getHand().size();
        if (number == 5) continue;
        else {
            for(int y = number; y < 5; y++){
                players.get(x).takeCard(players.get(0).dealACard()); 
            }
        }
        }
        players.get(0).evaluateTheHand(players.get(0).getHand());
        System.out.println();
        
        for (int x = 0; x < players.size(); x++){
           
        if (x == 0) System.out.println("Dealer's cards :");
        else System.out.println("Player " + (x) + "'s cards :");
           for (int y = 0; y < players.get(x).getHand().size();y++){
       
               
           
       System.out.println
                    ("Position " + (y+1) + ": " + players.get(x).getHand().get(y).getValue() 
                      + " of " + players.get(x).getHand().get(y).getSuite());          
    }
           System.out.println();
   }
       
       if (HandEvaluator.assessHand(players.get(0).getHand()) > HandEvaluator.assessHand(players.get(1).getHand()))
       System.out.println("The Dealer has won! Bad luck old chap.");
       
       else if (HandEvaluator.assessHand(players.get(0).getHand()) < HandEvaluator.assessHand(players.get(1).getHand()))
       System.out.println("Congratulations! You beat the Dealer.");
       
       else HandEvaluator.drawnHand(
                                    HandEvaluator.assessHand(players.get(0).getHand()), 
                                    players.get(0), 
                                    players.get(1)); 
           
           
 }
    
    public Hand getPlayerHand(int x)
    {
        return players.get(x).getHand();
    }
    
    public void changeUserCards(int[] x)
    {
        if (x.length == 0) return;  
        
    
    
    }
    
    
}
