import java.security.SecureRandom;
import java.util.ArrayList;

// claas that represent group of cards(deck), all the cards object will be store in array.
//the class will allow to create full decks or to create a sub deck from existing one 
//deal card,transfer cards, shuffle deck and deck size methods are available 
public class DeckOfCards {

	ArrayList<Card> deck = new ArrayList<>(); // array of Card objects
	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();

	// constructor fills deck of Cards
	public DeckOfCards()
	{	
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		deck = new ArrayList<Card>(); // create array of Card objects
		// populate deck with Card objects
		for (int count = 0; count < NUMBER_OF_CARDS; count++)
			deck.add(new Card(faces[count % 13], suits[count / 13]));
	}
	//constructor fills deck of Cards with cards of another deck
	public DeckOfCards(DeckOfCards pack, int numOfCards) {
		this.addCards(pack, numOfCards);
	}

	//remove cards from a deck and add it to another deck
	public void addCards(DeckOfCards pack, int numOfCards){
		for (int count = 0; count < numOfCards; count++)
		{
			deck.add(pack.dealCard(1));
			pack.deck.remove(0);
		}
	}
	// shuffle deck of Cards with one-pass algorithm
	public void shuffle()
	{
		// for each Card, pick another random Card (0-51) and swap them
		for (int first = 0; first < deck.size(); first++){
			// select a random number between 0 and 51
			int second = randomNumbers.nextInt(deck.size());

			// swap current Card with randomly selected Card
			Card temp = deck.get(first);
			deck.set(first,deck.get(second));
			deck.set(second, temp);
		}
	}
	// deal one Card
	public Card dealCard(int x)
	{
		// determine whether Cards remain c be dealt
		if (deck.size() >= x)
			return deck.get(x-1); // return first Card in array
		else
			return null;// return null to indicate that all Cards were dealt
	}
	public int howManyCards() {
		return deck.size();

	}
	public String toString()
	{
		return deck.toString();
	}

}// end class DeckOfCards
