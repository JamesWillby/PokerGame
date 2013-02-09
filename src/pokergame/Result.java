/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

/**
 *
 * @author jameswillby
 */
public class Result {
    private String title;
    private int number;        

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }
   
    public Result(String title, int number) {
    this.title = title;
    this.number = number;
    }
    
}
