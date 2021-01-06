package application;

public abstract class Utilisateur {

	private int id_User;
	private String nom_user;
	private String prenom_user;
	private int age_user;
	private String email_user;
	private String mdps_user;
	
	
	
	public Utilisateur( String nom_user, String prenom_user, int age_user, String email_user,String mdps_user) {
		super();
		this.nom_user = nom_user;
		this.prenom_user = prenom_user;
		this.age_user = age_user;
		this.email_user = email_user;
		this.mdps_user = mdps_user;
	}



	public int getId_User() {
		return id_User;
	}



	public void setId_User(int id_User) {
		this.id_User = id_User;
	}



	public String getNom_user() {
		return nom_user;
	}



	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}



	public String getPrenom_user() {
		return prenom_user;
	}



	public void setPrenom_user(String prenom_user) {
		this.prenom_user = prenom_user;
	}



	public int getAge_user() {
		return age_user;
	}



	public void setAge_user(int age_user) {
		this.age_user = age_user;
	}



	public String getEmail_user() {
		return email_user;
	}



	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}



	public String getMdps_user() {
		return mdps_user;
	}



	public void setMdps_user(String mdps_user) {
		this.mdps_user = mdps_user;
	}


	
}

