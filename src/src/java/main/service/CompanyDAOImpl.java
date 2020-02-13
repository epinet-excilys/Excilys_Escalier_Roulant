package src.java.main.service;

import java.sql.SQLException;
import java.util.List;

import src.java.main.dao.CompanyDAO;
import src.java.main.model.Company;

public final class CompanyDAOImpl {
	
private static volatile CompanyDAOImpl instance = null;
	
	
	private CompanyDAOImpl() {
        super();
    }
	
	public final static CompanyDAOImpl getInstance() {
		
		if (CompanyDAOImpl.instance == null) {

	           synchronized(CompanyDAOImpl.class) {
	             if (CompanyDAOImpl.instance == null) {
	            	 CompanyDAOImpl.instance = new CompanyDAOImpl();
	             }
	           }
	        }
	        return CompanyDAOImpl.instance;
		
	}

	public Company find(int i) {
		Company company = null;
		int a = -1;

		try {
			a = CompanyDAO.getInstance().getNbRow();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if ((i <= a) && (a != -1)) {
			try {
				company = CompanyDAO.getInstance().find(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return company;
	}

	public List<Company> getAllComput() {
		List<Company> list = null;
		try {

			list = CompanyDAO.getInstance().findAll();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	
	public int getNbRows() {
		int a = -1;
		try {
			a = CompanyDAO.getInstance().getNbRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	
}
