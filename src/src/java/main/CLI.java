package src.java.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import src.java.main.model.Computer;
import src.java.main.service.CompanyDAOImpl;
import src.java.main.service.ComputerDAOImpl;
import src.java.main.mapper.ComputerMapper;;

public class CLI {

	private static int VALEUR = -2;
	private Scanner sc;
	private String[] tabRep = {"","","","",""} ;

	public CLI() {
		sc = new Scanner(System.in);
		
	}

	public void demonstration() {
		int a = VALEUR;
		int commande = 0;
		afficher("Version t+3 de la BDD - acces console");

		while (a == VALEUR) {
			afficher("Saisir : 0 pour afficher la liste Computer");
			afficher("         1 pour afficher un Computer");
			afficher("         2 pour ajouter un Computer");
			afficher("         3 pour supprimer un Computer");
			afficher("         4 pour modifier un Computer");
			afficher("         5 pour afficher la liste Company");
			afficher("         6 pour quitter");
			commande = scannerQuestion(0, 6);
			switch (commande) {
			case 0:
				afficher("liste comput");
				affiAllComput();
				break;
			case 1:
				afficher("un comput");
				affiComput();
				break;
			case 2:
				afficher("ajout comput");
				addComput();
				break;
			case 3:
				afficher("suppr comput");
				deletComput();
				break;
			case 4:
				afficher("modif comput");
				break;
			case 5:
				afficher("affich company");
				break;
			case 6:
				afficher("Quitter le prog");
				a = 0;
				break;

			}

		}

	}

	// Methode Comput
	public void addComput() {
		
		Computer comp = null ;

		afficher("Vous allez saisir les valeurs champs par champs");
		
			int i = (ComputerDAOImpl.getInstance().getNbRows()+1);
			String passage_1 = ""+i+"";
			tabRep[0]=(passage_1);
			
			afficher("Saisir le nom");
			tabRep[1]= "Nom" ;//(sc.nextLine());
			
			afficher("Saisir la Date d'introduction sur le marché (AAAA-MM-dd");
			tabRep[2]=(sc.nextLine());
			
			afficher("Saisir la Date de retrait du le marché (AAAA-MM-dd");
			tabRep[3]=(sc.nextLine());
			
			afficher("Saisir l'id de la companie ");
			int a = scannerIdCompan("ajoutez");
			
			System.out.println(a);
			
			
			String passage_2 = a + "";
			tabRep[4]=(passage_2);
			
			comp = ComputerMapper.getInstance().fromStringToComput((tabRep));
			
			afficher("Vous voulez ajoutez cette machine" + comp);

		
		//ComputerDAOImpl.getInstance().add(comp);

	}

	public void modifComput() {

	}

	public void deletComput() {

		int a = scannerIdComput("supprimer");

		if (a != -1) {
			Computer comp = ComputerDAOImpl.getInstance().find(a);
			afficher(comp);

			ComputerDAOImpl.getInstance().delete(comp);
		} else {
			afficher("Pas de Correspondance en Base");
		}

	}

	public void affiComput() {

		int a = scannerIdComput("afficher");

		if (a != -1) {
			Computer comp = ComputerDAOImpl.getInstance().find(a);
			afficher(comp);
		} else {
			afficher("Pas de Correspondance en Base");
		}

	}

	public void affiAllComput() {
		List<Computer> list = ComputerDAOImpl.getInstance().getAllComput();

		for (Computer c : list) {
			afficher(c);
		}

	}

	// Methode
	// Compan-----------------------------------------------------------------------------------

	public void affiCompan() {

	}

	public void affiAllCompan() {

	}

	// Methode Console

	public void afficher(Object s) {
		System.out.println(s);
	}

	public int scannerQuestion(int premier_possib, int deuxiem_possib) {

		String rep;
		int repEnInt = -1;
		
		afficher("Entrer votre Choix : [" + premier_possib + ":" + deuxiem_possib + "]");

		do {
			
			if( repEnInt != -1 && (repEnInt < premier_possib || repEnInt > deuxiem_possib)) {
				repEnInt = -1;
				afficher("Entrer votre Choix : [" + premier_possib + ":" + deuxiem_possib + "]");
			}

			try {
				rep = sc.nextLine();

				repEnInt = Integer.parseInt(rep);

			} catch (Exception e) {
				afficher("Veuillez entrer une valeur compréhensible pour le programme");
				afficher("Entrer votre Choix : [" + premier_possib + ":" + deuxiem_possib + "]");
				repEnInt = -1;
			}

		} while (repEnInt == -1 || (repEnInt < premier_possib || repEnInt > deuxiem_possib));

		return repEnInt;

	}

	public int scannerIdComput(String personnalisation) {
		int valMaxId = ComputerDAOImpl.getInstance().getNbRows();
		int repEnInt = -1;
		String rep = "";
		if (valMaxId != -1) {
			afficher("Entrez l'ID de la machine que vous voulez " + personnalisation + " : (Nb max :" + valMaxId + ")");
			do {

				try {
					rep = sc.nextLine();

					repEnInt = Integer.parseInt(rep);

				} catch (Exception e) {
					afficher("Veuillez entrer une valeurs compréhensive pour le programme");
					repEnInt = -1;
				}

			} while (repEnInt == -1 || (repEnInt <= 0 && repEnInt > valMaxId));
		}

		return repEnInt;

	}

	//TODO REFAIRE CETTE FONCTION
	/*
	public boolean scannerSur() {

		String oui = "OUI";
		String non = "non";
		String rep = "vide";

		do {
			afficher("Etes vous sur ? [" + oui + ":" + non + "]");

			try {
				rep = sc.nextLine();

			} catch (Exception e) {
				afficher("Veuillez entrer une valeurs compréhensive pour le programme");
			}

		} while (!rep.contentEquals(oui) || !rep.contentEquals(non));

		if (rep.contentEquals(oui)) {
			return true;
		} else if (rep.contentEquals(non)) {
			return false;
		} else {
			afficher("Erreur de saisi");
			return false;
		}

	}
	*/
	
	public String scannerString(String personnalisation) {
		String rep ="non_valable";
		
		return rep; 
	}
	
	public int scannerIdCompan(String personnalisation) {
		int valMaxId = CompanyDAOImpl.getInstance().getNbRows();
		int repEnInt = -1;
		String rep = "";
		if (valMaxId != -1) {
			afficher("Entrez l'ID de la companie que vous voulez " + personnalisation + " : (Nb max :" + valMaxId + ")");
			do {

				try {
					rep = sc.nextLine();

					repEnInt = Integer.parseInt(rep);

				} catch (Exception e) {
					afficher("Veuillez entrer une valeurs compréhensive pour le programme");
					repEnInt = -1;
				}

			} while (repEnInt == -1 || (repEnInt <= 0 && repEnInt > valMaxId));
		}

		return repEnInt;

	}

}
