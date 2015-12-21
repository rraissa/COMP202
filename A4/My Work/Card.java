// Class to represent the notion of a playing card from a standard deck.
public class Card {
  // enum to represent the suit of this card.
 private Suit suit;
 
 // enum to represent the value of this card.
 public Value value;
 
 // constructor to allow for initialization of the card.
 public Card(Suit suit, Value value) {
  this.suit = suit;
  this.value = value;
 }
 
 // returns a Suit enum specifying what Suit this card holds.
 public Suit getSuit() {
  return this.suit; 
 }
 
 // returns a Value enum specifying what Value this card holds.
 public Value getValue() {
  return this.value;
 }
 
 // returns a String version of this Card.
 public String toString() {
  return  this.value + " OF " + this.suit;
 }
}
