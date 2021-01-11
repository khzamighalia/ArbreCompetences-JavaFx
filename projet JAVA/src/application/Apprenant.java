package application;

public class Apprenant extends Utilisateur {

	public Apprenant(String nom_user, String prenom_user, int age_user, String email_user, String mdps_user,
			String type_user) {
		super(nom_user, prenom_user, age_user, email_user, mdps_user, type_user);
		// TODO Auto-generated constructor stub
	}

	public Apprenant(int id_user, String nom_user, String prenom_user, String email_user, String type_user) {
		super(id_user, nom_user, prenom_user, email_user, type_user);
		// TODO Auto-generated constructor stub
	}

	
}