import java.util.Scanner;
public class CardGame {
	
	 public static void main(String[] args) {

		    System.out.println("Enter number of players: ");
		    //int nPlayers = Integer.parseInt(args[0]);
		    Scanner input = new Scanner(System.in);
		    int nPlayers = input.nextInt(); 
		    
		    CardPile deck = CardPile.makeFullDeck(); 
		    CardPile [] playersHand = new CardPile[nPlayers]; 


		    for (int i = 51; i >= 0 ; i--) {
		      int playersNum = i % nPlayers;
		      Card nextCard = deck.remove(i);
		      playersHand[playersNum].addToBottom(nextCard); 
		      
		    }
		    
		    for(int i = 0; i<nPlayers; i++){
		    	for(int j = 0; j<playersHand.length; j++){
		    System.out.println("Player " + (i+1) + " has " + playersHand[i] + " cards");
		    	}
		    }
		    
		   for (int i = 0; i < nPlayers ; i++) {
		      if (playersHand[i].find(Suit.SPADES, Value.ACE) != -1) {
		        System.out.println("Player" + i + "has won!");
		      }
		    }

		  }

}
