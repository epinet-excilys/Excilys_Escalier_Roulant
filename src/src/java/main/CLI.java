package src.java.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import src.java.main.model.Computer;
import src.java.main.service.ComputerDAOImpl;



public class CLI {
	
	
	private static int valeur = -2;
	private Scanner sc ;
	private ComputerDAOImpl computerDAOimpl ;
	
	
	public CLI() {
		sc = new Scanner(System.in);
		computerDAOimpl = new ComputerDAOImpl();
	}
	
	public void demonstration() {
		int a = valeur;
		int commande = 0;
		afficher("Version t+3 de la BDD - acces console");
		
		while (a == valeur) {
			afficher("Saisir : 0 pour afficher la liste Computer" );
			afficher("         1 pour afficher un Computer" );
			afficher("         2 pour ajouter un Computer" );
			afficher("         3 pour supprimer un Computer" );
			afficher("         4 pour modifier un Computer" );
			afficher("         5 pour afficher la liste Company" );
			afficher("         6 pour quitter" );
			commande = scannerQuestion(0,6);
			switch(commande) {
			case 0 :
				afficher("liste comput");
				affiAllComput();
				break;
			case 1 :
				afficher("un comput");
				break;
			case 2 :
				afficher("ajout comput");
				break;
			case 3 :
				afficher("suppr comput");
				break;
			case 4 :
				afficher("modif comput");
				break;
			case 5 :
				afficher("affich company");
				break;
			case 6 :
				afficher("Quitter le prog");
				a = 0;
				break;
				
			}

		}
		
	}
	
	
	// Methode Comput
	public void addComput() {
		
	}
	
	public void modifComput() {
		
	}
	
	public void deletComput() {
		
	}
	
	public void affiComput() {
		
	}
	
	public void affiAllComput() {
		
		
		
	}
	
	//Methode Compan
	
	public void affiCompan() {
		
	}
	
	public void affiAllCompan() {
		
	}
	
	//Methode Console
	
	public void afficher(Object s) {
		System.out.println(s);
	}
	
	public int scannerQuestion(int premier_possib, int deuxiem_possib) {
		
		String rep;
		int repEnInt=-1;
		afficher("Entrer votre Choix : ["+ premier_possib + ":" + deuxiem_possib +"]");
		
		do {
			
			try {
			rep=sc.nextLine();
			
			repEnInt = Integer.parseInt(rep);
			
			}catch (Exception e) {
				afficher("Veuillez entrer une valeurs compréhensive pour le programme");
				repEnInt=-1;
			}
			
		} while (repEnInt == -1 || (repEnInt < premier_possib && repEnInt > deuxiem_possib));
		
		
		
		return repEnInt;
		
	}
	
	
	

}
