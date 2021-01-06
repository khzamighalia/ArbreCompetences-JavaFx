package application;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CompetencesController {

    //@FXML
    //private ComboBox<?> ref_choix;
    //ObservableList<String> options = 
    	//    FXCollections.observableArrayList("Option 1","Option 2","Option 3");
   

    //ref_choix = new ComboBox(options);
	@FXML
	ComboBox<String> ref_choix = new ComboBox<>();
	ObservableList<String> products = FXCollections.observableList(Arrays.asList("Chalk", "Books", "Cup"));
	ref_choix.setItems(products);

}
