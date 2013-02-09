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
public class DealerBrain {

    private static String[] categories = {"High Card", "Two Pair", "Three", "Full House", "Straight", "Flush"};
    private Vector<Result> analysis = null;
    private int highCard = 0;

    public DealerBrain() {
        analysis = new Vector<Result>();
        for (int x = 0; x < categories.length; x++) {
            analysis.add(new Result(categories[x], 0));
        }
    }

    public void analyzeOurHand(Vector<Card> hand) { // Look at the current hand to determine components

        highCard = hand.get(0).getValue();
        for (int x = 1; x < hand.size() - 1; x++) {
            if (hand.get(x).getValue() >= hand.get(x - 1).getValue()) {
                highCard = hand.get(x).getValue();
            }
        }
    }
}
