package application;

public class Referentiel {

	private int id_Ref;
	private String nom_ref;

	public Referentiel(int id_Ref, String nom_ref) {
		super();
		this.id_Ref = id_Ref;
		this.nom_ref = nom_ref;
	}
	public Referentiel() {

	}
	public int getId_Ref() {
		return id_Ref;
	}

	public void setId_Ref(int id_Ref) {
		this.id_Ref = id_Ref;
	}

	public String getNom_ref() {
		return nom_ref;
	}

	public void setNom_ref(String nom_ref) {
		this.nom_ref = nom_ref;
	}

}