import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Maman11bController {

	@FXML
	private Canvas canv;
	private GraphicsContext gc;
	final double PREC_OF_FILLED = 0.10;// % of the cells to be filled
	final int SIZE = 20;
	final int TOTAL = SIZE*SIZE;// total; amount of cells in the matrix
	final int WIDTH = 10;//each 10 is 10 pixels
	public void initialize() {
		gc = canv.getGraphicsContext2D();
	}


	@FXML
	void shufflePress(ActionEvent event) {
		gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());// create and empty matrix 
		Random r = new Random();
		for(int i = 0; i < SIZE; i++ ) {
			for(int j = 0; j < SIZE; j++ ) {

				gc.setStroke(Color.BLACK);
				gc.strokeRect(i*WIDTH, j*WIDTH, WIDTH, WIDTH);
			}
		}
		for(int i = 1; i <= PREC_OF_FILLED*(TOTAL) ; i++) {//paint the required amount of cells in black 
			gc.setFill(Color.BLACK);
			gc.fillRect(r.nextInt(20)*WIDTH, r.nextInt(20)*WIDTH, WIDTH, WIDTH);
		}


	}

}
