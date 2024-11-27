import javafx.scene.paint.Color;

public class Game {
	final int STRIKE = 4;
	private int arr[][] = null; 
	private int column,row,counter,temp,startDiagRow,startDiagCol;
	private boolean isWin;
	private int currPlayerPlaying = 1;//player 1 color is red
	public  Game(int row, int column) {
		this.row = row;
		this.column = column;
		arr = new int[row][column];
	}
	protected int currPlayerPlaying(){
		return currPlayerPlaying;
	}

	protected Color currPlayerColor() {
		if (currPlayerPlaying == 1) {
			return Color.RED;
		}
		return Color.BLUE;

	}
	protected int availableRow (int column) {
		for(int i = row - 1; i >= 0; i--) {
			if(arr[i][column]==0) {
				return i;
			}
		}
		return -1;

	}
	
	protected void add(int playedRow,int playedCol) {
		arr[playedRow][playedCol] = currPlayerPlaying;
	}
	
	protected boolean winning(int playedRow, int playedColumn) {
		isWin = (isRowStrike(playedRow,playedColumn)||isColStrike(playedRow,playedColumn)||isRDiagStrike(playedRow,playedColumn)||isLDiagStrike(playedRow,playedColumn));
		if(!isWin) 
			changePlayer();
		return isWin;
		
	}
	
private void changePlayer() {
	if(currPlayerPlaying == 1)
		currPlayerPlaying = 2;
	else
		currPlayerPlaying = 1;
}

private boolean isRowStrike(int playedRow, int playedColumn) {
	counter = 0;

	for( int i = 0; i < column; i++) {
		if(arr[playedRow][i] == currPlayerPlaying) {
			counter ++;
			if(counter == STRIKE) {
				return true;
			}
		} 
		else {
			counter = 0;
		}
	}
	return false;
}

private boolean isColStrike(int playedRow, int playedColumn) {
	counter = 0;
	for( int i = 0; i < row; i++) {
		if(arr[i][playedColumn] == currPlayerPlaying) {
			counter ++;
			if(counter == STRIKE) {
				return true;
			}
		} 
		else {
			counter = 0;
		}
	}
	return false;

}


private boolean isRDiagStrike(int playedRow, int playedColumn) {
	counter = 0;
	temp = Math.min(row -playedRow, column - playedColumn)-1;
	startDiagCol = playedColumn + temp;
	startDiagRow = playedRow + temp;
	for( int i = 0; i < column; i++) {
		if(startDiagRow-i>=0 && startDiagCol-i >=0 && (arr[startDiagRow-i][startDiagCol-i] == currPlayerPlaying)){
			counter++;
			if(counter == STRIKE) {
				return true;

			}
		}
		else {
			counter = 0;
		}

	}
	return false;
}


private boolean isLDiagStrike(int playedRow, int playedColumn) {
	counter = 0;
	temp = Math.min(row -1 -playedRow, playedColumn);
	startDiagCol = playedColumn - temp;
	startDiagRow = playedRow + temp;
	for( int i = 0; i < column; i++) {
		if(startDiagRow-i>=0 && startDiagCol+i < column && (arr[startDiagRow-i][startDiagCol+i] == currPlayerPlaying)){
			counter++;
			if(counter == STRIKE) {
				return true;
			}

		}
		else {
			counter = 0;
		}
	}
	return false;
}

protected void newGame() {
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < column; j++) {
			arr[i][j] = 0; 
		}
	}
	currPlayerPlaying = 1;
}
}






