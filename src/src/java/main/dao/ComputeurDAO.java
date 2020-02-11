package src.java.main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import src.java.main.model.*;

public class ComputeurDAO extends DAO<Computer>{

	public ComputeurDAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Computer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Computer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Computer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Computer find(int i) {
		Computer computer = new Computer(); 
		// TODO Auto-generated method stub
		
		try {
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM computer WHERE id = " + i);
		      if(result.first())
		        computer = new Computer(i,
		        		result.getString("nom"),
		        		result.getDate("introduced"),
		        		result.getDate("discontinued"),
		        		Integer.valueOf(result.getString("company_id")));   
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		 
		return computer;
	}
	
	public ArrayList<Computer> findAll(){
		
		ArrayList<Computer> list = new ArrayList<Computer>();
		Computer computer;
		
		try {
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM computer");

		      
			while(result.next()) {
		        computer = new Computer(result.getInt("id"),
		        		result.getString("name"),
		        		result.getDate("introduced"),
		        		result.getDate("discontinued"),
		        		result.getInt("company_id"));   
			
			list.add(computer);
			}
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		
		return list;
	}

	//Pas utile pour le moment
	private Date FromStringtoDate(String s) throws ParseException {
		 SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
		 
		    Date date2=(Date) formatter2.parse(s);
		    
		    return date2;
		
	}
	
	
	    

}
