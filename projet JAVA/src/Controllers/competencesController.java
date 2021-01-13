package Controllers;

import java.sql.SQLException;

import Precedures.ProcLinkDB;
import application.Referentiel;
import application.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class competencesController {

    @FXML
    private Text Label_NomApprenant;

    @FXML
    private Text Label_NomStaff;

    @FXML
    private ComboBox<String> ref_choix;

	public void initialize() {
		//initialize interface
	Utilisateur User = ProcLinkDB.getUser(ProcLinkDB.id_Session);
	Referentiel Refe = ProcLinkDB.Referance();
	if (User != null) {
		// get Staff info's 
		Label_NomApprenant.setText(User.getPrenom_user()+" "+User.getNom_user());
		Label_NomStaff.setText("Wait SQL Staff");

		// REF MYSQL
		
		ref_choix.setItems(FXCollections.observableArrayList(Refe.getNom_ref()));
		
		//
	} else {
		System.out.println("Erreur");
	}

}
    
    
    
    
    
}
