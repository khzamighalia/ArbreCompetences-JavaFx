package application;

public class Competence extends Referentiel {

	private int id_cmptnce;
	private String nom_cmptnce;

	public Competence(int id_Ref, String nom_ref) {
		super(id_Ref, nom_ref);
		// TODO Auto-generated constructor stub
	}

	public Competence(String nom_ref, int id_Ref, int id_cmptnce, String nom_cmptnce) {
		super(id_Ref, nom_ref);
		this.id_cmptnce = id_cmptnce;
		this.nom_cmptnce = nom_cmptnce;

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

	public void setNom_cmptnce(String cmptnce) {
		this.nom_cmptnce = cmptnce;
	}

}