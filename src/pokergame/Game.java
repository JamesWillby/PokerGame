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
    
    public void playGame()
    {
    
        
    }
    
      
    public Hand getPlayerHand(int x)
    {
        return players.get(x).getHand();
    }
    
    
}
