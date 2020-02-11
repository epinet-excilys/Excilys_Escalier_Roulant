package src.java.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import src.java.main.dao.*;
import src.java.main.model.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DAO<Computer> computerDao = new ComputeurDAO();
		
		//ArrayList<Computer> array = computerDao.findAll();

		ArrayList<Company> array2 = null;
		try {
			array2 = CompanyDAO.getInstance().findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Company c : array2) {
			System.out.println(c);
		}
		
		
		
		
		
	}

}
 