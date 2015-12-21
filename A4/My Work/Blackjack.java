import java.lang.*;
import java.util.Scanner;
public class Blackjack{

	public static void main(String[] args){
		int n = 4;
		Results resultRound;
		int nChips = Integer.parseInt("50");
		boolean endOfGame = false;
		CardPile deck = CardPile.makeFullDeck(n);
		
		
		while(!endOfGame){
			
			Scanner inputBet = new Scanner(System.in);
			System.out.println("Place a bet: ");
			int bet = inputBet.nextInt();
			
			if (bet < 0){
				endOfGame = true;
				System.out.println(" ");
				System.out.println("The game ended because the player chose to leave the game.");
			}
			
			else if(bet <= nChips){
				resultRound = playRound(deck);
				
				if(resultRound == Results.PLAYER_WINS){
					nChips = nChips + bet;
				}
				
				if(resultRound == Results.DEALER_WINS){
					nChips = nChips - bet;
				}
				
				if(resultRound == Results.BLACKJACK){
					Double d = new Double(1.5*bet);
					int i = d.intValue();
					nChips = nChips + i;
				}
				
				
				System.out.println("Player has " + nChips + " chips remaining.");
				System.out.println(" ");
				
				if(nChips == 0){
					endOfGame = true;
					System.out.println(" ");
					System.out.println("The game ended because the player ran out of chips.");
				}
				
				int nCards = deck.getNumCards();
				if(nCards <= 10){
					System.out.println(" ");
					System.out.println("The game ends because we have only " + nCards + " cards left.");
					endOfGame = true;
				}
			}
			
			
			else{
				System.out.println("You cannot bet more chips than you have.");
				}
		}
	}
	
	public enum Results{
		DEALER_WINS,
		PLAYER_WINS,
		TIE,
		BLACKJACK,
	}
	
	private static Value value;
	public static int roundnumber = 0;
	
	
	public static int getScore(Card aCard){
		if(aCard.value.ordinal() == 12){
			return 11;
		}
		if (aCard.value.ordinal() > 7){
    		return 10;
    	}
    	return aCard.value.ordinal() + 2;
	}
	
	public static int countValues(CardPile hand){
		int handScore = 0;
		int aceCount = 0;
		
		for(int i = 0; i < hand.getNumCards(); i++){
			int cardValue = getScore(hand.get(i));
			handScore = handScore + cardValue;
			if(cardValue == 11){
				aceCount = aceCount + 1;
			}
		 }
		while (handScore > 21 && aceCount > 0){	
			aceCount = aceCount - 1;
			handScore = handScore - 10;	
		}
		return handScore;
	}
	
	
	public static Results playRound(CardPile round){
		Scanner input = new Scanner(System.in);
		CardPile player = new CardPile();
		CardPile dealer = new CardPile();
		
		
		player.addToBottom(round.remove(0));
		player.addToBottom(round.remove(0));
		dealer.addToBottom(round.remove(0));
		dealer.addToBottom(round.remove(0));
		int playerScore = countValues(player);
		int dealerScore = countValues(dealer);
		roundnumber = roundnumber + 1;
		System.out.println("[ROUND NUMBER " + roundnumber + "]");
		System.out.println(" ");
		System.out.println("Player's score is: " + playerScore + " and his hand is: " + player);
		System.out.println("Dealer's second card: " + dealer.get(1));
		
		
		if(playerScore == 21 || dealerScore == 21){
			if(playerScore != 21){
				System.out.println("Dealer dealt blackjack, dealer wins. Player's count value is: " + playerScore + ".");
				System.out.println(" ");
				System.out.println(" ");
				return Results.DEALER_WINS;
				}
			else if(dealerScore != 21){
				System.out.println("Player dealt blackjack, player wins. Dealer's count value is: " + dealerScore + ".");
				System.out.println(" ");
				System.out.println(" ");
				return Results.BLACKJACK;
				}
			else{
				System.out.println("Player and dealer dealt blackjack, it's a tie.");
				System.out.println(" ");
				System.out.println(" ");
				return Results.TIE;
				}
			}
		
					
		boolean hit = true; 
		while(hit && playerScore <= 21){
			System.out.println(" ");
			System.out.println("hit or stay?");
			String hitOrStay = input.next();
			
			while(!hitOrStay.toLowerCase().equals("hit") && !hitOrStay.toLowerCase().equals("stay")){
			System.out.println(" ");
			System.out.println("Wrong input, enter 'hit' or 'stay'.");
			hitOrStay = input.next();
				}
			
			if(hitOrStay.toLowerCase().equals("hit")){
				player.addToBottom(round.remove(0));
				playerScore = countValues(player);
				System.out.println(" ");
				System.out.println("Player's score is: " + playerScore + " and his hand is: " + player);
			}
			else{
				System.out.println(" ");
				//hit = false;
				break;
			}
		}
		
		playerScore = countValues(player);
		
		if(playerScore > 21){
			System.out.println("Player busts with count value of " + playerScore + ", dealer wins.");
			System.out.println(" ");
			System.out.println(" ");
			return Results.DEALER_WINS;
		}
		
		while(dealerScore < 18){
			dealer.addToBottom(round.remove(0));
			dealerScore = countValues(dealer);
			System.out.println("Dealer's score is: " + dealerScore + " and his hand is: " + dealer);
		}
		
		
		if(dealerScore > 21){
			System.out.println("Dealer busts with count value of " + dealerScore + ", player wins.");
			System.out.println(" ");
			System.out.println(" ");
			return Results.PLAYER_WINS;
		}
		
		//if no one busts
		if(playerScore < dealerScore){
			System.out.println("Dealer wins with count value of: " + dealerScore + ". Player's count value is: " + playerScore);
			System.out.println(" ");
			System.out.println(" ");
			return Results.DEALER_WINS;
		}
		
		if(playerScore > dealerScore){
			System.out.println("Player wins with count value of: " + playerScore + ". Dealer's count value is: " + dealerScore);
			System.out.println(" ");
			System.out.println(" ");
			return Results.PLAYER_WINS;
		}
		
		if(playerScore == dealerScore){
			System.out.println("It's a tie, with count values of: " + playerScore);
			System.out.println(" ");
			System.out.println(" ");
			return Results.TIE;
		}
		return Results.TIE;
	}
}
