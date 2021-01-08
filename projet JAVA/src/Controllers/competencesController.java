package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class competencesController implements Initializable {
	 
	@FXML
	    private ComboBox<String> ref_choix;

	    @FXML
	    private Text label;

	    @FXML
	    void select(ActionEvent event) {
	    	String s=ref_choix.getSelectionModel().getSelectedItem().toString();
	    	label.setText(s);
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			ObservableList<String> list = FXCollections.observableArrayList("Développeur⋅se web et web mobile ","Concepteur⋅rice développeur⋅se d'applications");
			ref_choix.setItems(list);
			/*ObservableList<String> list = ref_choix.getItems();
		      //Adding items to the combo box
		      list.add("Java");
		      list.add("C++");
		      list.add("Python");
		      list.add("Big Data");
		      list.add("Machine Learning");*/
			
		}

}
