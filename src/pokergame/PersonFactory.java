/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

/**
 *
 * @author jameswillby
 */
public interface PersonFactory {
    
  public Dealer getNewDealer();
  public Player getNewPlayer();
}
