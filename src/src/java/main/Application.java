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

		
		CLI cli = new CLI();
		
		cli.demonstration();

		/* GetAll();
		 * 
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
		*/
		
		
		
		/* find et 
		
		try {
			Computer comp = ComputerDAO.getInstance().find(5);
			System.out.println(comp);
			
			comp.setId(1000);
			comp.setName("UnPcLambda");
			 
			ComputerDAO.getInstance().create(comp);
			
			Computer comp2 = ComputerDAO.getInstance().find(1000);
			System.out.println(comp2);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		/*
		try {
			Computer comp = ComputerDAO.getInstance().find(5);
			System.out.println(comp);
			comp.setCompanyId(2);
			
			ComputerDAO.getInstance().update(comp);
			
			Computer comp2 = ComputerDAO.getInstance().find(5);
			System.out.println(comp2);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		
		
		
		
		
	}

}
 