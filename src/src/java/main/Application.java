package src.java.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Iterator;

import src.java.main.dao.*;
import src.java.main.model.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		List<Company> list = null;
		List<Computer> list2 = null;
		
		try {
			list = CompanyDAO.getInstance().findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			list2 = ComputerDAO.getInstance().findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for(Company c : list) {
			System.out.println(c);
		}
		
		for(Computer c : list2) {
			System.out.println(c);
		}
		
		
		
		
	}

}
 