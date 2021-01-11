package Controllers;

import java.io.IOException;

import Precedures.ProcLinkDB;
import application.Apprenant;
import application.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RechercheController {
	public static int id_Session_Apprenant=1;
	@FXML
	private Text Label_nomStaff;

	@FXML
	private Text Label_prenomStaff;

	@FXML
	private Text Label_emailStaff;

	@FXML
	private AnchorPane AnchorRecherche;
	@FXML
	private Button btn_recherche;
	@FXML
	private TextField id_Text;

	@FXML
	public void initialize() {
			//initialize interface
		Utilisateur User = ProcLinkDB.getUser(ProcLinkDB.id_Session);

		if (User != null) {
			// get Staff info's 
			Label_nomStaff.setText(User.getNom_user());
			Label_prenomStaff.setText(User.getPrenom_user());
			Label_emailStaff.setText(User.getEmail_user());

		} else {
			System.out.println("Erreur");
		}

	}

	public void ClickRecherche(ActionEvent event) {
		// open new window Apprenant info's
		Window owner = btn_recherche.getScene().getWindow();
		if (id_Text.getText().isEmpty()) {
			ProcLinkDB.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter id Apprenant");
			return;
		}
		id_Session_Apprenant=Integer.parseInt(id_Text.getText());	
		
		
		try {
			Stage dialogStage = new Stage();
			Scene scene = null;
			Node source = (Node) event.getSource();
			dialogStage = (Stage) source.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Interfaces/ViewApprenant.fxml"));
			Parent root = (Parent) loader.load();
			scene = new Scene(root);
			dialogStage.setScene(scene);
			dialogStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
