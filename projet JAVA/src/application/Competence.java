package application;

import javafx.scene.control.Button;

public class Competence extends Referentiel {

	private int id_cmptnce;
	private String nom_cmptnce;
	private int niveau;
	private Button Inc;
	private Button Dec;
	public Competence(int id_Ref, String nom_ref) {
		super(id_Ref, nom_ref);
		// TODO Auto-generated constructor stub
	}
	public Competence(int id_Ref, String nom_ref, int id_cmptnce, String nom_cmptnce, int niveau) {
		super(id_Ref, nom_ref);
		this.id_cmptnce = id_cmptnce;
		this.nom_cmptnce = nom_cmptnce;
		this.niveau = niveau;
		this.Inc=new Button(" + ");
		this.Dec=new Button(" - ");

	}
	public int getId_cmptnce() {
		return id_cmptnce;
	}
	public void setId_cmptnce(int id_cmptnce) {
		this.id_cmptnce = id_cmptnce;
	}
	public String getNom_cmptnce() {
		return nom_cmptnce;
	}
	public void setNom_cmptnce(String nom_cmptnce) {
		this.nom_cmptnce = nom_cmptnce;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Button getButtonInc() {
		return Inc;
	}
	public void setButtonInc(Button Inc) {
		this.Inc = Inc;
	}
	
	public Button getButtonDec() {
		return Dec;
	}
	public void setButtonDec(Button Dec) {
		this.Dec = Dec;
	}

}