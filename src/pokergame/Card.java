/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

/**
 *
 * @author jameswillby
 */
public class Card {
    
    private String suite;
    private int value;
    
    public Card(String su, int x)
    {
        this.suite = su;
        this.value = x;
    }
    
    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuite() {
        return suite;
    }

    public int getValue() {
        return value;
    }
   
    boolean equals(Card e)
    {
    if (this.suite.equals(e.getSuite()) && this.value == e.getValue())
        return true;
    return false;
    }
}
