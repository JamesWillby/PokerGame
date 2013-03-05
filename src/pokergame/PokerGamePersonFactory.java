/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

/**
 *
 * @author jameswillby
 */
public class PokerGamePersonFactory {
    
public PokerGamePerson returnPerson(String person){ // returns a class implementing PokerGamePerson
       
switch(person){ // here we call private factory methods

    case "dealer" : return getNewDealer(); 
    case "player" : return getNewPlayer();
    default: return null;
}}

    private Dealer getNewDealer()
    { return new Dealer();}
    
    private Player getNewPlayer()
    { return new Player();}
    
    
}

