package Controllers;

import java.io.IOException;
import Precedures.ProcLinkDB;
import application.Apprenant;
import application.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

	public void Clicklogin(ActionEvent event) {
		Window owner = submitButton.getScene().getWindow();
		System.out.println(emailIdField.getText());
		System.out.println(passwordField.getText());

		if (emailIdField.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email id");
			return;
		}
		if (passwordField.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
			return;
		}
		String emailId = emailIdField.getText();
		String password = passwordField.getText();

		Utilisateur User = ProcLinkDB.login(emailId, password);
		try {
			if (User != null) {

				
				infoBox("Login Successful!", null, "Failed");

				Stage dialogStage = new Stage();
				Scene scene;
				Node source = (Node) event.getSource();
				dialogStage = (Stage) source.getScene().getWindow();

				if (User.getClass() == Apprenant.class) {
				scene = new Scene(FXMLLoader.load(getClass().getResource("../Interfaces/competences.fxml")));
				dialogStage.setScene(scene);
				dialogStage.show();
				}else {
					scene = new Scene(FXMLLoader.load(getClass().getResource("../Interfaces/recherche.fxml")));
					dialogStage.setScene(scene);
					dialogStage.show();
				}
				
			} else {
				infoBox("Please enter correct Email and Password", null, "Failed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}

	private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}