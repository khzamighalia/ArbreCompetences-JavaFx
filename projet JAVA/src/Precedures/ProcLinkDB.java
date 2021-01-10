package Precedures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controllers.RechercheController;
import application.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;

public class ProcLinkDB implements Interface_User_Competence {
	public static int id_Session = 0;
	public static Connection Connection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:8000/_Tree_?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
					"root", "admin");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}


	
	
	public static Utilisateur login(String email_user, String mdps_user) {
		Utilisateur user = null;
		try {
			String query = "SELECT * FROM utilisateur WHERE email_user=? and mdps_user=?";
			Connection con = ProcLinkDB.Connection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email_user);
			ps.setString(2, mdps_user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(7).equals("Apprenant")) {
					user = new Apprenant(rs.getString(2), rs.getString(3), rs.getInt(4), email_user, mdps_user,
							rs.getString(7));
					id_Session=(rs.getInt(1));
				} else {
					user = new Staff(rs.getString(2), rs.getString(3), rs.getInt(4), email_user, mdps_user,
							rs.getString(7));
					id_Session=(rs.getInt(1));
				}
				user.setId_User(rs.getInt(1));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

    public static Utilisateur getUser(int id_User) {
		Utilisateur user = null;

    	try {
    		String query="SELECT * from utilisateur where id_user="+id_User;
    		Connection con = ProcLinkDB.Connection();
			Statement stmt=con.createStatement(); 	
			ResultSet rs=stmt.executeQuery(query);
			if (rs.next()) {
				if (rs.getString(7).equals("Apprenant")) {
					user = new Apprenant(rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),
							rs.getString(7));
					id_Session=(rs.getInt(1));
				} else {
					user = new Staff(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),
							rs.getString(7));
					id_Session=(rs.getInt(1));
				}
				user.setId_User(rs.getInt(1));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
    }



	public static void Visualisation(int id_user) {
		try {
			lists_Competences.clear();
			String query = "SELECT utilisateur.nom_user,utilisateur.prenom_user,competence.id_cmptnce,competence.nom_cmptnce,referentiel.nom_ref,niveaau.n1,niveaau.n2,niveaau.n3 from utilisateur,competence,niveaau,referentiel where utilisateur.id_user=niveaau.id_user and niveaau.id_cmptnce=competence.id_cmptnce and competence.id_ref=referentiel.id_ref and utilisateur.id_user="
					+ id_user;
			Connection con = ProcLinkDB.Connection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lists_Competences.add(new Competence(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// void infoBox
		public static void infoBox(String infoMessage, String headerText, String title) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(infoMessage);
			alert.setTitle(title);
			alert.setHeaderText(headerText);
			alert.showAndWait();
		}
		// void showAlert 
		public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
			Alert alert = new Alert(alertType);
			alert.setTitle(title);
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.initOwner(owner);
			alert.show();
		}
	
	
	}