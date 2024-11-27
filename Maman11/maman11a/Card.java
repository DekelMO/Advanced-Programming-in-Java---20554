//card class - each card will have its value and it suit in addition the class will allow to compare between cards and convert them into string.
public class Card {

	private final String face; // face of card ("Ace", "Deuce", ...)
	private final String suit; // suit of card ("Hearts", "Diamonds", ...)

	// two-argument constructor initializes card's face and suit
	public Card(String cardFace, String cardSuit)
	{
		this.face = cardFace; // initialize face of card
		this.suit = cardSuit; // initialize suit of card
	}
	// return String representation of Card
	public String toString() 
	{
		return face + " of " + suit;
	}
	//compare between two cards and return the greater card or null if the card are equals. 
	public Card greaterThan(Card secCard)
	{
		String[] options = {"Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		int firstCardIndex = options.length ; //Default value outside the array 
		int secondCardIndex = options.length ; //Default value outside the array 
		for (int count = 0; count < options.length && firstCardIndex == options.length; count++) {//converting the string value to int value
			if(this.face.equals(options[count])) {
				firstCardIndex = count;
			}

		}
		for (int count = 0; count < options.length && secondCardIndex == options.length; count++) {//converting the string value to int value
			if(secCard.face.equals(options[count])) {
				secondCardIndex = count;
			}
		}
		if(firstCardIndex>secondCardIndex){
			return this;
		}
		else if(firstCardIndex<secondCardIndex)	
			return secCard;
		else return null;
	}
}// end class Card


