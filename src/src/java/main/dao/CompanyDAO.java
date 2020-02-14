package src.java.main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import src.java.main.model.*;


// A FAIRE
public final class CompanyDAO {

	private Connection connect;
	private static volatile CompanyDAO instance = null;
	private final String getStatement = "select id, name from company where id=?";
	private final String getAllStatement = "select company.id, company.name from company";
	private final String getNbRowsStatement = "SELECT COUNT(*) as \"Rows\" FROM company;";
	
	
	
	

	private CompanyDAO() {
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

	public void create(Company obj) {
	}

	public void delete(Company obj) {
	}

	public void update(Company obj) {
	}

	public Company find(int i) throws SQLException {

		Company company = new Company();

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement(getStatement);
			stmt.setInt(1, i);

			ResultSet result = stmt.executeQuery();

			if (result.first())
				company = new Company(i, result.getString("name"));

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
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
			PreparedStatement stmt = connect.prepareStatement(getAllStatement);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				company = new Company(result.getInt("id"), result.getString("name"));

				list.add(company);
			}

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
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
			PreparedStatement stmt = connect.prepareStatement(getNbRowsStatement);
			ResultSet result = stmt.executeQuery();

			if (result.first()) {
				a = result.getInt("Rows");

			}

		} catch (SQLException e) {
			//TODO remplir avec les Logs
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
		
		return a;
		
	}

}
