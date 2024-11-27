import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Q1Controller {

    @FXML
    private ColorPicker btnColor;

    @FXML
    private RadioButton btnEllipse;

    @FXML
    private RadioButton btnEmpty;

    @FXML
    private RadioButton btnFilled;

    @FXML
    private RadioButton btnLine;

    @FXML
    private RadioButton btnRectangle;

    @FXML
    private ToggleGroup filling;

    @FXML
    private Pane pane;

    
    private double xPress,yPress,xRelease,yRelease,topLeftX,topLeftY,width,height;
    private int lastIndex;
    private Shape currShape= null;
    
    public void initialize() {
    	Rectangle clip = new Rectangle();
    	clip.widthProperty().bind(pane.widthProperty());
    	clip.heightProperty().bind(pane.heightProperty());
    	pane.setClip(clip);
    }
    @FXML
    void btnClear(ActionEvent event) {
    	pane.getChildren().clear();
    }
    
    @FXML
    void btnUndo(ActionEvent event) {
    	lastIndex = pane.getChildren().size()-1;
    	if(lastIndex >= 0)
    		pane.getChildren().remove(lastIndex);

    }

    @FXML
    void pressed(MouseEvent event) {
    	xPress = event.getX();
   	 	yPress = event.getY();
    }

    @FXML
    void released(MouseEvent event) {
    	
    	
    	xRelease = event.getX();
   	 	yRelease = event.getY();
   	 	//if(xRelease >)
        width = Math.abs(xRelease - xPress);
        height = Math.abs(yRelease - yPress);
        if (btnEllipse.isSelected()) {
        	topLeftX = (xPress + xRelease)/2;
            topLeftY = (yPress + yRelease)/2;
        	currShape = new Ellipse(topLeftX, topLeftY, width/2, height/2);
        } else if (btnRectangle.isSelected()) {
        	topLeftX = Math.min(xPress,xRelease);
            topLeftY = Math.min(yPress,yRelease);
            currShape = new Rectangle(topLeftX, topLeftY, width, height);
        } else if (btnLine.isSelected()) {
            currShape = new Line(xPress, yPress, xRelease, yRelease);
        }
        creation(btnFilled.isSelected(), btnColor.getValue(), currShape);
    }
    


private void creation(boolean fill,Color color, Shape currShape) {
	currShape.setStroke(color);
	if(fill)
		currShape.setFill(color);
	else
		currShape.setFill(Color.TRANSPARENT);
	pane.getChildren().add(currShape);
    }
}
