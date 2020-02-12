package src.java.main.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.java.main.dao.ComputerDAO;
import src.java.main.model.Computer;

public class ComputerDAOImpl {
	
	
	// A MODIFIER
	public void update(Computer obj) {
		Computer comp = null;
		try {
			comp = ComputerDAO.getInstance().find(obj.getId());
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		if(comp != null) {
			try {
				ComputerDAO.getInstance().update(obj);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add (Computer obj) {
		Computer comp = null;
		try {
			comp = ComputerDAO.getInstance().find(obj.getId());
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		if(comp == null) {
			try {
				ComputerDAO.getInstance().create(obj);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete (Computer obj) {
		Computer comp = null;
		try {
			comp = ComputerDAO.getInstance().find(obj.getId());
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		if(comp != null) {
			try {
				ComputerDAO.getInstance().delete(comp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	//
	public Computer find(int i) {
		Computer comp = null;
		try {
			comp = ComputerDAO.getInstance().find(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return comp;
	}

	public List<Computer> getAllComput() {
		List<Computer> list = null;
		try {

			list = ComputerDAO.getInstance().findAll();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
