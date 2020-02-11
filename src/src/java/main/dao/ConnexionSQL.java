package src.java.main.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionSQL {
	
	private static String url = "jdbc:mysql://localhost:3306/computer-database-db";

	private static String user = "nom_utilisateur_choisi";

	private static String password = "mot_de_passe_solide";

	private static Connection connect;
	
	
	
	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	


}
