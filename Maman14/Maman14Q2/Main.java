import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{ 

	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Maman14Q2.fxml")); 
		Scene scene = new Scene(root); 
		stage.setTitle("Maman14Q2"); 
		stage.setScene(scene); 
		stage.show(); 
	} 

	public static void main(String[] args) { 
		launch(args); 
		System.out.println();
	} 
}
