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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
	@FXML
	private TextField emailIdField;

	@FXML
	private TextField passwordField;

	@FXML
	private Button submitButton;
		
	//Click sur button login EVENT
	public void Clicklogin(ActionEvent event) {
		
		// get new window
		Window owner = submitButton.getScene().getWindow();

		// if email and password empty -> show error alert  
		if (emailIdField.getText().isEmpty()) {
			ProcLinkDB.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email id");
			return;
		}
		if (passwordField.getText().isEmpty()) {
			ProcLinkDB.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
			return;
		}
		
		// add values of email and password to String 
		String emailId = emailIdField.getText();
		String password = passwordField.getText();
		
		//Get user email and password from login() class ProcLinkDB
		Utilisateur User = ProcLinkDB.login(emailId, password);
		try {
			// we have User 
			if (User != null) {
				ProcLinkDB.infoBox("Login Successful!", null, "Failed");

				// open new window Competences.fxml Apprenant interface
				Stage dialogStage = new Stage();
				Scene scene = null;
				Node source = (Node) event.getSource();
				dialogStage = (Stage) source.getScene().getWindow();
				if (User.getClass() == Apprenant.class) {
					FXMLLoader loader = new FXMLLoader (getClass().getResource("../Interfaces/ViewApprenant2.fxml"));
					Parent root = (Parent) loader.load();
					scene = new Scene(root);
					dialogStage.setScene(scene);
					dialogStage.show();

				}else {
					// open new window Recherche.fxml Staff interface
					FXMLLoader loader = new FXMLLoader (getClass().getResource("../Interfaces/recherche.fxml"));
					Parent root = (Parent) loader.load();
					scene = new Scene(root);
					dialogStage.setScene(scene);
					dialogStage.show();
				}
			} else {
				// Alert if email or password not correct
				ProcLinkDB.infoBox("Please enter correct Email and Password", null, "Failed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}