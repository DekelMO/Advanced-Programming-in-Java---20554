import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Q2Controller {

	@FXML
	private GridPane btnGrid;
	@FXML
	private GridPane gameGrid;
	final private int NUM_OF_COLUMNS = 7;
	final private int NUM_OF_GAME_ROWS = 6;
	private int playedCol,playedRow;
	private Game game;
	private Circle circle[][] = new Circle[NUM_OF_GAME_ROWS][NUM_OF_COLUMNS];

	public void initialize() {
		gameGrid.setGridLinesVisible(true);
		btnGrid.setGridLinesVisible(true);
		createButton();
		game = new Game(NUM_OF_GAME_ROWS,NUM_OF_COLUMNS);
		fillGameBoard();
	}
	@FXML
	void clearPressed(ActionEvent event) {
		resetGameBoard();
	}
	private Button[] createButton() {
		Button arr[] = new Button[NUM_OF_COLUMNS];
		for(int i = 0; i<NUM_OF_COLUMNS ; i++) {
			arr[i] = new Button(""+(i+1));
			arr[i].setPrefSize(gameGrid.getPrefWidth()/NUM_OF_COLUMNS, btnGrid.getPrefHeight());
			arr[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					handleButton(e);
				}
			});
			btnGrid.add(arr[i],i, 0);
		}
		return arr;
	}
	private void handleButton(ActionEvent e) {

		playedCol = Integer.parseInt(((Button)e.getSource()).getText())-1;
		playedRow = game.availableRow(playedCol);
		if(playedRow == -1){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("The Column is full");
			alert.setContentText("Please choose a column with available slot");
			alert.showAndWait();
		}
		else {
			circle[playedRow][playedCol].setFill(game.currPlayerColor());
			game.add(playedRow, playedCol);
			if (game.winning(playedRow,playedCol)) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("WIN");
				alert.setHeaderText("We have a winner:");
				alert.setContentText("Player #" + game.currPlayerPlaying());
				alert.showAndWait();
				resetGameBoard();
			}

		}
	}

	private void fillGameBoard() {
		for (int row = 0; row < NUM_OF_GAME_ROWS; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				Circle oneCircle = new Circle();
				oneCircle.setRadius(gameGrid.getPrefHeight()/NUM_OF_GAME_ROWS/2 -1); 
				oneCircle.setFill(Color.TRANSPARENT); 
				GridPane.setHalignment(oneCircle, HPos.CENTER);
	            GridPane.setValignment(oneCircle, VPos.CENTER);
				circle[row][col] = oneCircle;
				gameGrid.add(oneCircle, col, row);; 
			}
		}
	}
	public void resetGameBoard() {
		for (int row = 0; row < NUM_OF_GAME_ROWS; row++) {
			for (int col = 0; col < NUM_OF_COLUMNS; col++) {
				circle[row][col].setFill(Color.TRANSPARENT);
			}
		}
		game.newGame();

	}
}
