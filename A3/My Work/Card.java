public class Card {
	
	
	public static void main(String[] args){
	
	}
	
	
	private Value value;
    private Suit suit;
  
   

	public Card(Suit theSuit, Value theValue){
		//initialize properties
		 this.value = theValue;
	     this.suit = theSuit;

	}
	
	public Suit getSuit(){
		//return value of suit property
		return suit;
	}
	
	public Value getValue(){
		//return value of value property
		return value;
	}
	
	public String toString(){
		//return a String form of the Card, eg: ACE of SPADES.
		return value.toString() + " of " + suit.toString();
	}
	
}
