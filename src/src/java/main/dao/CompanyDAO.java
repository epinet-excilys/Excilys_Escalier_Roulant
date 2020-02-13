package src.java.main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

import src.java.main.model.*;

public final class CompanyDAO {

	private Connection connect;
	private static volatile CompanyDAO instance = null;

	private CompanyDAO() {// seul le singleton s'appelle
		super();
	}

	public final static CompanyDAO getInstance() {

		if (CompanyDAO.instance == null) {

			synchronized (CompanyDAO.class) {
				if (CompanyDAO.instance == null) {
					CompanyDAO.instance = new CompanyDAO();
				}
			}
		}
		return CompanyDAO.instance;

	}

	@Override
	public boolean create(Company obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Company obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Company obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Company find(int i) throws SQLException {
		// TODO Auto-generated method stub

		Company company = new Company();
		// TODO Auto-generated method stub

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement("select * from company where id=?");
			stmt.setInt(1, i);

			ResultSet result = stmt.executeQuery();

			if (result.first())
				company = new Company(i, result.getString("name"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

		return company;
	}

	public ArrayList<Company> findAll() throws SQLException {

		ArrayList<Company> list = new ArrayList<Company>();
		Company company;

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement("select * from company");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				company = new Company(result.getInt("id"), result.getString("name"));

				list.add(company);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

		return list;
	}
	
	public int getNbRow () throws SQLException {
		int a = 0;
		
		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement("SELECT COUNT(*) as \"Rows\" FROM company;");
			ResultSet result = stmt.executeQuery();

			if (result.first()) {
				a = result.getInt("Rows");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Base non-atteinte");
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
		
		return a;
		
	}

}
