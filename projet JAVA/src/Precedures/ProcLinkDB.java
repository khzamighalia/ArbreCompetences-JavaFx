package Precedures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.*;

public class ProcLinkDB implements Interface_User_Competence {

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
				} else {
					user = new Staff(rs.getString(2), rs.getString(3), rs.getInt(4), email_user, mdps_user,
							rs.getString(7));
				}
				user.setId_User(rs.getInt(1));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static void ListApprenants() {
		try {
			lists_Utilisateurs.clear();
			String query = "SELECT * FROM `utilisateur` WHERE type_user='Apprenant'";
			Connection con = ProcLinkDB.Connection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lists_Utilisateurs.add(new Apprenant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(7)));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Visualisation(int id_user) {
		try {
			lists_Competences.clear();
			String query = "SELECT utilisateur.nom_user,competence.id_cmptnce,competence.nom_cmptnce,referentiel.nom_ref,niveaau.n1,niveaau.n2,niveaau.n3 from utilisateur,competence,niveaau,referentiel where utilisateur.id_user=niveaau.id_user and niveaau.id_cmptnce=competence.id_cmptnce and competence.id_ref=referentiel.id_ref and utilisateur.id_user="
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

	/*
	 * public static void Valider(int id){ for (Competence competence :
	 * lists_Competences) { try { String query =
	 * "UPDATE `niveaux` SET `niveau`=? WHERE id_competence=? and id_user=?";
	 * Connection con = ProcLinkDB.Connection(); PreparedStatement ps =
	 * con.prepareStatement(query); ps.setInt(1, competence.getNiveau());
	 * ps.setInt(2, competence.getId()); ps.setInt(3, id); ps.executeUpdate();
	 * con.close(); } catch (SQLException e) { e.printStackTrace(); } } }
	 */
	}