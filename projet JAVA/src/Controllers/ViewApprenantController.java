package Controllers;

import Precedures.ProcLinkDB;
import application.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
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
	
    private Text txt_idRef;

    @FXML
    private Text txt_ref;

    @FXML
    private Text txt_idcmpt;

    @FXML
    private Text txt_cmpt;

    @FXML
    private Text txt_nv;

    @FXML
	private TableView<Competence> Table_view;
	@FXML
	private TableColumn<Competence,String> TestViewColumn;

	@FXML
	public void initialize() {
		Competence cmp = ProcLinkDB.Visualisation(RechercheController.id_Session_Apprenant);
		if (cmp != null) {

			txt_idRef.setText(String.valueOf(cmp.getId_Ref()));
			txt_ref.setText(cmp.getNom_cmptnce());
			txt_idcmpt.setText(String.valueOf(cmp.getId_cmptnce()));
			txt_cmpt.setText(cmp.getNom_cmptnce());
			txt_nv.setText(String.valueOf(cmp.getNiveau()));
			
			
			
			//TestViewColumn.setCellValueFactory(new PropertyValueFactory(cmp.getNom_cmptnce()));
			//TestViewColumn.setCellValueFactory(new PropertyValueFactory<Competence, String>("name"));
			//Table_view.setItems(cmp.getId_Ref());
			//TestViewColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNom_cmptnce()));
			//Table_view.setItems(cmp);
			//TestViewColumn.setText("Nom competences");
		} else {
			System.out.println("Erreur");
		}
	}

}
