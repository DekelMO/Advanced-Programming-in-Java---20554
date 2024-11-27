import javax.swing.JOptionPane;
//The game its self manage with popups messages 
//the deck is divided evenly among the players, giving each a down stack. 
//In unison, each player reveals the top card of their deck—this is a "battle"—and the player with the higher card takes both of the cards played and moves them to the end of its deck.
//If the two cards played are of equal value, then there is a "war".
//The game will continue until one player has collected all of the cards.
public class Maman11 {
	public static void main(String[] args) {
		boolean play = true;//while playing 
		while(play == true) {
			int choice = JOptionPane.showConfirmDialog(null, "Hello player, do you wanna start new game?", "Confirmation", JOptionPane.YES_NO_OPTION);
			// Check the user's choice and display a corresponding message 
			// If the user chose 'Yes', the game will start be shuffling the deck and split it to two equal decks
			if (choice == JOptionPane.YES_OPTION) { 
				DeckOfCards pack = new DeckOfCards();
				pack.shuffle();
				DeckOfCards player = new DeckOfCards(pack,26);
				DeckOfCards comp = new DeckOfCards(pack,26);
				boolean inGame = true;//while in a specific game 
				while(inGame == true) {
					//Before each round we will ensure that the players still have cards to play otherwise the winner will be announce 
					if (player.howManyCards() <= 0) {
						JOptionPane.showMessageDialog(null, "computer won the game :(");
						inGame = false;
					}
					else if(comp.howManyCards() <= 0){
						JOptionPane.showMessageDialog(null, "You won the game!!! :)");
						inGame = false;
					}
					else {
						int choice1 = JOptionPane.showConfirmDialog(null, "Ready for battle?\nchoose YES to reveal a card\n NO for leaving the game\n X for closing the game", "Confirmation", JOptionPane.YES_NO_OPTION);
						if (choice1 == JOptionPane.YES_OPTION) { 
							int warCounter = 0;
							int cardIndex = 1;
							boolean flag = true;// use to stop the game when one of the player have no cards
							Card winner = player.dealCard(cardIndex).greaterThan(comp.dealCard(cardIndex));//the winner card of the match
							while(winner == null && flag) {// war loop - if both cards are equal (no winner) the a war will start.The loop will check how many back to back wars accrue and jump(jump of 4) to non equal cards
								//while saving the amount of skipped cards so when the war over the winner will get all the skipped cards
								warCounter++;
								JOptionPane.showMessageDialog(null, "Your card: " + player.dealCard(cardIndex) + " VS computer card: " + comp.dealCard(cardIndex) + "\nBoth cards are have equal value, ITS A WAR!\nPut 3 cards and lets try again");
								cardIndex = warCounter*4 + 1;
								// if during the war one player is out of cards the other player won the game
								if (player.howManyCards() < cardIndex) {
									JOptionPane.showMessageDialog(null, "You out of cards" + "\n" + "Computer won the game :(");
									inGame = false;
									flag = false;
								}
								else if(comp.howManyCards() < cardIndex){
									JOptionPane.showMessageDialog(null, "Computer is out of cards" + "\n" +"You won the game!!! :)");
									inGame = false;
									flag = false;
								}

								else
									winner = player.dealCard(cardIndex).greaterThan(comp.dealCard(cardIndex));//save the winner in the end of the war
							}

							//check who is the winner of the match and announce it, in addition the loser card(or cards incase of a war) will transfer to the winner and all the played cards will transfer to the end of the deck 
							if (flag == true && winner == player.dealCard(cardIndex)) {
								JOptionPane.showMessageDialog(null, "your card: " + player.dealCard(cardIndex) + " VS computer card: " + comp.dealCard(cardIndex) + "\n" + "You won the match, " + 
										"you got " + cardIndex + " cards" + "\nYou have " + (player.howManyCards()+cardIndex) + " cards."); 
								player.addCards(comp, cardIndex);
								player.addCards(player, cardIndex);
							}
							else if(flag == true && winner == comp.dealCard(cardIndex)) {
								JOptionPane.showMessageDialog(null, "your card: " + player.dealCard(cardIndex) + " VS computer card: " + comp.dealCard(cardIndex) + "\n" + "The computer won the match, " + 
										"you lost " + cardIndex + " cards" + "\nYou have " + (player.howManyCards()-cardIndex) + " cards."); 
								comp.addCards(player, cardIndex);
								comp.addCards(comp, cardIndex);
							}

						}

						else if (choice1 == JOptionPane.NO_OPTION) {
							JOptionPane.showMessageDialog(null, "Sorry to hear that maybe next time");
							inGame = false;
						}
						else {
							JOptionPane.showMessageDialog(null, "bye bye..."); ; 
							inGame = false;
							play = false;
						}

					}
				} 
			}
			else { 
				// If the user choose "no" or "close", show a message indicating the operation is cancelled 
				play = false;
				JOptionPane.showMessageDialog(null, "bye bye..."); }
		}

	}
}
