package Controllers;

import Precedures.ProcLinkDB;
import application.Competence;
import application.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ViewApprenantController {

    @FXML
    private Text nom_Apprenant;

    @FXML
    private Text prenom_Apprenant;

    @FXML
    private Text email_Apprenant;
    @FXML
    private Text referentiel;

    @FXML
    private Text ref;


    @FXML
    private TableView<Competence> Table_view;

    @FXML
    private TableColumn<Competence,String> competencet;

    @FXML
    private TableColumn<Competence, Integer> niveaut;
    

   
    
    @FXML
	public void initialize() {
			//initialize interface
  
		Utilisateur User = ProcLinkDB.getUser(ProcLinkDB.id_Session);
		ObservableList<Competence> cmp = FXCollections.observableArrayList();

		if (User != null  ) {
			// get Staff info's 
			Utilisateur apprenant = ProcLinkDB.getUser(RechercheController.id_Session_Apprenant);
			nom_Apprenant.setText(apprenant.getNom_user());
			prenom_Apprenant.setText(apprenant.getPrenom_user());
			email_Apprenant.setText(apprenant.getEmail_user());
			cmp=ProcLinkDB.getCompetence(RechercheController.id_Session_Apprenant);
			ref.setText(cmp.get(0).getNom_ref());
			competencet.setCellValueFactory(new PropertyValueFactory<Competence,String>("nom_cmptnce")
				);
			niveaut.setCellValueFactory(new PropertyValueFactory<Competence,Integer>("niveau"));
			Table_view.setItems(cmp);
			//}
				

		} else {
			System.out.println("Erreur");
		}

	}


}
