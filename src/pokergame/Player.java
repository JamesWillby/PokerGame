/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame;

import java.util.Scanner;
/**
 *
 * @author jameswillby
 */
class Player implements PokerGamePerson{

    private Hand cards = null;    
    
    public Player()
    {
        cards = new Hand();
    }
    
    
    @Override
    public void takeCard(Card cr) {
        cards.add(cr);
    }

    @Override
    public Card throwAwayCard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void evaluateTheHand(Hand player) {
        
        System.out.println
                    ("Your cards are: ");
        for (int x = 0; x < cards.size(); x++){
            System.out.println
                    ("Position " + (x+1) + ": " + player.get(x).getValue() + " of " + player.get(x).getSuite());
        }
        System.out.println();
        System.out.println
                    ("Your may switch up to three cards of your choice.");
        System.out.println();
        System.out.println
                    ("How many cards would you like to change?");
        
        Scanner scanner = new Scanner(System.in);
        int number_of_cards = scanner.nextInt();
        
        switch (number_of_cards)
        {
            case 1 : 
            {
                System.out.println
                        ("Ok. Please enter the position of the card you want to change");
                int position;
                position = scanner.nextInt();
                position = position - 1;
                Hand newHand = new Hand();
                
                for(int x = 0; x < cards.size();x++){
                    if (x == position)continue;
                    newHand.add(cards.get(x));
                }
                
                cards = null;
                cards = newHand;
                return;
                
            } 
                case 2 : 
            {
                System.out.println
                        ("Ok. Please enter the positions of the 2 cards you want to change");
                int position1, position2;
                position1 = scanner.nextInt();
                position1 = position1 - 1;
                position2 = scanner.nextInt();
                position2 = position2 - 1;
                Hand newHand = new Hand();
                
                for(int x = 0; x < cards.size();x++){
                    if (x == position1 || x == position2)continue;
                    newHand.add(cards.get(x));
                }
                
                cards = null;
                cards = newHand;
                return;
                
            } 
                case 3 : 
            {
                System.out.println
                        ("Ok. Please enter the positions of the 3 cards you want to change");
                int position1, position2, position3;
                position1 = scanner.nextInt();
                position1 = position1 - 1;
                position2 = scanner.nextInt();
                position2 = position2 - 1;
                position3 = scanner.nextInt();
                position3 = position3 - 1;
                Hand newHand = new Hand();
                
                for(int x = 0; x < cards.size();x++){
                    if (x == position1 || x == position2 || x == position3)continue;
                    newHand.add(cards.get(x));
                }
                cards = null;
                cards = newHand;
                return;       
            }    
                case 0: System.out.println("Great");
        }
        
        
        
        
        
    }

    @Override
    public void shuffleTheDeck() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addToDiscardPile(Card cr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int cardsRemainingInTheDeck() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Card dealACard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Hand getHand() {
       return cards;
    }
}
