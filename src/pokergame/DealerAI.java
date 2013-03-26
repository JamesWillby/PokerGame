package pokergame;

import java.util.Vector;

public class DealerAI {
	
	 Hand hand;
	 Vector<Card> swapcardsonecard;
	 Vector<Card> swapcardstwocards;
	 Vector<Card> swapcardsthreecards;
	 Vector<Card> swapcardsnocards = new Vector<Card>();
	int currentrank;
	
        public DealerAI(Hand myhand) {  
		this.hand = new Hand(); //create new Hand so doesn't alter it
		for (int k = 0; k < myhand.size(); k++)  
			hand.add(myhand.get(k));
                
                /** Here we have three vectors to decide whether we want to 
                 * swap 1, 2 or 3 cards
                 */
                
		this.swapcardsonecard = new Vector<Card>();
		this.swapcardstwocards = new Vector<Card>();
		this.swapcardsthreecards = new Vector<Card>();
		this.currentrank = HandEvaluator.assessHand(hand);
	}

	 public Vector<Card> whichCardsShouldISwap() {
		
            /** Here we calculate the possible difference in rank for swapping
             * 1,2 or 3 cards. The double returns the effect on rank of the current 
             * hand for making the specified number of changes
             */ 
            
		 if (currentrank >= 4)
				return swapcardsnocards;
		 
		Double bestrankdiffonecard = rankDiffSwapOneCard();
		
		Double bestrankdifftwocards = rankDiffSwapTwoCards();
		
		Double bestrankdiffthreecards = rankDiffSwapThreeCards();
		
		
		if ((bestrankdiffonecard > bestrankdifftwocards) && (bestrankdiffonecard > bestrankdiffthreecards))
			return swapcardsonecard;
		else if (bestrankdifftwocards > bestrankdiffthreecards)
			return swapcardstwocards;
		else if (bestrankdiffthreecards != 0)
				return swapcardsthreecards;
		else return swapcardsnocards;
		
	}
	
	private  Double rankDiffSwapOneCard() {
	
    Double rankdiffonecard = 0.0; // rank difference
	Card bestcardtoswap = null;
	

	for (int i = 0; i < hand.size(); i++){
		Double temprankdiff = rankDiffIfSwapped(i);
		if (rankdiffonecard < temprankdiff){
			rankdiffonecard = temprankdiff;
			bestcardtoswap = hand.get(i);
			}
				
		}
		
		
		
		swapcardsonecard.add(bestcardtoswap);
		return rankdiffonecard;
	}
		
	private  Double rankDiffSwapTwoCards() {
		
		Double rankdiff = 0.0;
		int bestcardoneindex = 0;
		int bestcardtwoindex = 0;
		Card bestcardtoswapcardone;
		Card bestcardtoswapcardtwo;
		

		for (int i = 0; i < hand.size() - 1 ; i++)
			for (int j = i + 1 ; j < hand.size() ; j++ ){
				Double temprankdiff = rankDiffIfSwapped(i, j);
				if (rankdiff < temprankdiff){
				rankdiff = temprankdiff;
				bestcardoneindex = i;
				bestcardtwoindex = j;
				}
			}
		
		bestcardtoswapcardone = hand.get(bestcardoneindex);
		bestcardtoswapcardtwo = hand.get(bestcardtwoindex);
		
		swapcardstwocards.add(bestcardtoswapcardone);
		swapcardstwocards.add(bestcardtoswapcardtwo);
		
		
		return rankdiff;
	}
			
			
	private  Double rankDiffSwapThreeCards() {
		
		Double rankdiff = 0.0;
		int bestcardoneindex = 0;
		int bestcardtwoindex = 0;
		int bestcardthreeindex = 0;
		Card bestcardtoswapcardone;
		Card bestcardtoswapcardtwo;
		Card bestcardtoswapcardthree;
		

		for (int i = 0; i < hand.size() - 2 ; i++)
			for (int j = i+1; j < hand.size() - 1 ; j++ )
				for (int k = j+1; k < hand.size(); k++){
					Double temprankdiff = rankDiffIfSwapped(i, j, k);
					if (rankdiff < temprankdiff){
						rankdiff = temprankdiff;
						bestcardoneindex = i;
						bestcardtwoindex = j;
						bestcardthreeindex = k;
				}
			}
		
		bestcardtoswapcardone = hand.get(bestcardoneindex);
		bestcardtoswapcardtwo = hand.get(bestcardtwoindex);
		bestcardtoswapcardthree = hand.get(bestcardthreeindex);
		
		
		swapcardsthreecards.add(bestcardtoswapcardone);
		swapcardsthreecards.add(bestcardtoswapcardtwo);
		swapcardsthreecards.add(bestcardtoswapcardthree);
		
		 
		return rankdiff;
	}

	private  Double rankDiffIfSwapped(int cardi) {
	/**
         * Here we create a new Special Deck containing all the cards
         * bar those in our current hand. We then iterate through all
         * 47 other cards and determine how each card will alter the 
         * rank of the current hand.
         */
            
		Double rankdiffifswapped = 0.0;
		SpecialDeck tempdeck = new SpecialDeck(hand);
		for (int j = 0; j < 47 ; j++){
			Hand temphand = new Hand();
			for (int k = 0; k < hand.size(); k++){
				if (k == cardi)
					temphand.add(tempdeck.get(j));
				else temphand.add(hand.get(k));
				}
			
			
			int temphandrank = HandEvaluator.assessHand(temphand);
			
			
			int temprankdiff =  temphandrank - currentrank;
			rankdiffifswapped = rankdiffifswapped + temprankdiff;
			
			}
		
		rankdiffifswapped = rankdiffifswapped / 47;
		return rankdiffifswapped;
	}	
	
	private  Double rankDiffIfSwapped(int cardi, int cardm) {
		
		Double rankdiffifswapped = 0.0;
		SpecialDeck tempdeck = new SpecialDeck(hand);
		for (int j = 0; j < 47 ; j++){
			Hand temphand = new Hand();
			for (int k = 0; k < hand.size(); k++){
				if (k == cardi)
					temphand.add(tempdeck.get(j));
				else temphand.add(hand.get(k));
				}
			Hand temphand2 = new Hand();
			for (int z = 0; z < hand.size(); z++)
				temphand2.add(temphand.get(z));
			temphand2.add(hand.get(cardi));
			SpecialDeck tempdeck2 = new SpecialDeck(temphand2);
			
				for (int l = 0; l < 46; l++){
					
				temphand.setElementAt(tempdeck2.get(l), cardm);
				int temphandrank = HandEvaluator.assessHand(temphand);
				int temprankdiff = temphandrank - currentrank;
				rankdiffifswapped = rankdiffifswapped + temprankdiff;
				}	
		}		
		rankdiffifswapped = rankdiffifswapped / (47*46);			
		return rankdiffifswapped;
	}	
	
	
	private  Double rankDiffIfSwapped(int cardi, int cardm, int cardn) {
			
		Double rankdiffifswapped = 0.0;
		SpecialDeck tempdeck = new SpecialDeck(hand);
			for (int j = 0; j < 47 ; j++){
                            Hand temphand = new Hand();
				for (int k = 0; k < hand.size(); k++){
					if (k == cardi)
						temphand.add(tempdeck.get(j));
					else temphand.add(hand.get(k));
					}
				Hand temphand2 = new Hand();
				for (int z = 0; z < hand.size(); z++)
					temphand2.add(temphand.get(z));
				temphand2.add(hand.get(cardi));
				SpecialDeck tempdeck2 = new SpecialDeck(temphand2);
				for (int l = 0; l < 46; l++){
					temphand.setElementAt(tempdeck2.get(l), cardm);
				Hand temphand3 = new Hand();
				for (int z = 0; z < hand.size(); z++)
					temphand3.add(hand.get(z));
					temphand3.add(hand.get(cardi));
					temphand3.add(hand.get(cardm));
					SpecialDeck tempdeck3 = new SpecialDeck(temphand3);
				for (int m = 0; m < 45; m ++){
					
					temphand.setElementAt(tempdeck3.get(m), cardn);
					int temphandrank = HandEvaluator.assessHand(temphand);
					int temprankdiff = temphandrank - currentrank;
					rankdiffifswapped = rankdiffifswapped + temprankdiff;
					
					}
				}	
			}
			rankdiffifswapped = rankdiffifswapped / (47*46*45);
			
		return rankdiffifswapped;
	}
	
}
