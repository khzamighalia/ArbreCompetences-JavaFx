package Controllers;

import Precedures.ProcLinkDB;
import application.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class RechercheController {
	@FXML
	private Text Label_nomStaff;

	@FXML
	private Text Label_prenomStaff;

	@FXML
	private Text Label_emailStaff;

	@FXML
	private AnchorPane AnchorRecherche;

	@FXML
	public void initialize() {

		Utilisateur User = ProcLinkDB.getUser(ProcLinkDB.id_Session);

		if (User != null) {
			Label_nomStaff.setText(User.getNom_user());
			Label_prenomStaff.setText(User.getPrenom_user());
			Label_emailStaff.setText(User.getEmail_user());

		} else {
			System.out.println("Erreur");
		}
	}

}
