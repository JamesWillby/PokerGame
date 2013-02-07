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
public class Suite {
    
    private String name;
    private static int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private static String[]names = {"Two","Three","Four",
                                    "Five","Six","Seven","Eight",
                                    "Nine","Ten","Jack","Queen","King","Ace"};  
    
    private Vector<Card> cards = null;
    
     public int size()
   {return cards.size();}
     
      public Suite(String name)
    {
    setName(name);
    setUpSuite();
    }
    
    
     public String getName() 
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
 
 private void setUpSuite()
         
 {
   cards = new Vector<Card>();
   for (int x = 0;x < names.length;x++)
   {
       Card card = new Card(getName(),names[x],values[x]);
       cards.add(card);
   }
 }
 
 public Vector<Card> getCards()
 {
  return cards;   
 }
 
}