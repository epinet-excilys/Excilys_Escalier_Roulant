package src.java.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import src.java.main.dao.*;
import src.java.main.model.Computer;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connec = ConnexionSQL.getInstance();
		DAO<Computer> computerDao = new ComputeurDAO(connec);
		
		ArrayList<Computer> array = computerDao.findAll();
		Iterator it = array.iterator();
		
		System.out.print("bonjour1");
		
		for(Computer c : array) {
			System.out.println(c + "bleu");
		}
		

		
		System.out.print("bonjour2");
		
		
	}

}
