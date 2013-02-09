/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

/**
 *
 * @author jameswillby
 */
public class Participants implements PersonFactory {
    @Override
    public Dealer getNewDealer() {
        return new Dealer();
    }

    @Override
    public Player getNewPlayer() {
        return new Player();
    }
    
    public Plays returnPlayer(String name)
    {
      if (name.equals("Dealer"))  
        getNewDealer();
      if (name.equals("Player"))
          getNewPlayer();
     return null;
    } 
}
