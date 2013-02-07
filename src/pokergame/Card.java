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
    
    private String suite,name;
    private int value;
    
    public Card(String su, String nm, int x)
    {
        this.suite = su;
        this.name = nm;
        this.value = x;
    }
    
    public String returnName()
    {
        return name + " of " + suite;
        
    }
    
    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuite() {
        return suite;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
    
}
