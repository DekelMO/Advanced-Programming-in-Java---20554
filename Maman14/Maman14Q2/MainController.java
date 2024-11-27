import java.util.Map;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
//Any input provided with capital letters or with leading and trailing spaces will be automatically converted to lowercase and leading and trailing spaces will be removed.
public class MainController {

	@FXML
	private TextField definition;

	@FXML
	private TextField lexeme;

	@FXML
	private TextField lexemeSD;

	@FXML
	private ListView<Map.Entry<String,String>> list;

	private Dictionary dictionary ;
	private String lex,def;

	public void initialize() {
		dictionary = new Dictionary();  
		updateListView();  
	}

	@FXML
	void btnAdd(ActionEvent event) {
		lex = lexeme.getText().toLowerCase().trim();
		def = definition.getText().toLowerCase().trim();
		if (lex != null && !lex.isEmpty() && def != null && !def.isEmpty()) {
			if(dictionary.getDictionary().containsKey(lex)) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("The lexeme is already existing in the definition");
				alert.setContentText("If i wanna edit it use the search option to find the lexeme and then the edit button for edditing");
				alert.showAndWait();
			}
			else {	
				dictionary.getDictionary().put(lex, def); 
				updateListView();  
			}
		}
		lexeme.clear();
		definition.clear();
	}

	@FXML
	void btnDelete(ActionEvent event) {
		Map.Entry<String, String> selected = list.getSelectionModel().getSelectedItem();
		if (selected != null) {
			dictionary.getDictionary().remove(selected.getKey());
			updateListView();
		}
		else {
			noSelection();
		}



	}


	@FXML
	void btnEdit(ActionEvent event) {
		Map.Entry<String, String> selected = list.getSelectionModel().getSelectedItem();
		if (selected != null) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setHeaderText("Please enter the new definition \n empty definition wont be updated");
			Optional<String> result= dialog.showAndWait();
			if(result.isPresent() && !(result.get().isEmpty())) {
				def = result.get().toLowerCase().trim();
				dictionary.getDictionary().put(selected.getKey(),def) ;
				updateListView();
			}
		}
		else {
			noSelection();
		}

	}

	@FXML
	void btnSeach(ActionEvent event) {
		lex = lexemeSD.getText().toLowerCase();
		if (lex != null && !lex.isEmpty() && dictionary.getDictionary().containsKey(lex)) {
			Map.Entry<String, String> floorEntry = dictionary.getDictionary().floorEntry(lex);
			list.getSelectionModel().select(floorEntry);
			list.scrollTo(floorEntry);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("The lexeme was not found ib the dictionary");
			alert.showAndWait();
		}
		lexemeSD.clear();
		definition.clear();
	}


	private void updateListView() {
		list.getItems().clear();  // Clear the ListView
		list.getItems().addAll(dictionary.getDictionary().entrySet());
	}
	private void noSelection() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("No lexeme Selected");
		alert.setContentText("Please select a lexeme from the list.");
		alert.showAndWait();
	}


}
