public class CardPile {
	
public static void main(String[] args){
	
	//CardPile test = new CardPile();
	//test.makeFullDeck();
	
}
	
	private Card[] cards;
    private int numCards;
   
	
    public CardPile(){
    	this.cards = new Card[52]; 
    	this.numCards = 0;
    }
    
    public void addToBottom(Card c){
    	this.cards[numCards] = c;
    	numCards = numCards + 1;
    	
    }
    
    public boolean isEmpty(){
    	if(this.numCards == 0){
    	return true;
    	}
    	return false;
    }
    
    
    public Card get(int i){
    	if(i < numCards){
    		return this.cards[i];
    	}
    	return null;
    }
    
    public Card remove(int i){
    	Card removedCard = this.cards[i];
    	for(int j = i; j < numCards-1; j++){
    		this.cards[j] = this.cards[j+1];
    	}
    	
    	this.cards[numCards - 1] = null;
    	numCards = numCards - 1;
    	
    	return removedCard;
    	
    }
    
    public int find(Suit s, Value v){
    	 for(int i = 0 ; i < cards.length; i++){
    	      if(this.cards[i].getSuit() == s && this.cards[i].getValue() == v){ 
    	        return i;
    	      }
    	    }
    	    return -1;
    }
    
    public String toString(){
    	    String x = "";  
    	    String y = "";
    	    

    	    for(int i = 0; i < numCards; i++){  
    	      y = cards[i].toString();
    	      x = x + y + ", "; 
    	    }
    	    return x;
    }
    
    public static CardPile makeFullDeck(){
    	 CardPile shuffledDeck = new CardPile(); 
    	    for(Value v: Value.values()){
    	      for(Suit s: Suit.values()){
    	        shuffledDeck.addToBottom(new Card(s, v)); 
    	      }
    	    }

    	    UtilityCode.shuffle(shuffledDeck.cards, shuffledDeck.numCards);
    	    
    	    //System.out.println(shuffledDeck);
    	    return shuffledDeck;
    	
    }
    

}
