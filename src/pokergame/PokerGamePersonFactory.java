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
    
public PokerGamePerson returnPerson(String person){
       
switch(person){

    case "dealer" : return getNewDealer();
    case "player" : return getNewPlayer();
    case "referee" : return getNewReferee();
    default: return null;
}}

    private Dealer getNewDealer()
    { return new Dealer();}
    
    private Player getNewPlayer()
    { return new Player();}
    
    private Referee getNewReferee()
    { return new Referee();}  
    
}

