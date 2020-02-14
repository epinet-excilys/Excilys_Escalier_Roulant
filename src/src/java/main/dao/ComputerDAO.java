package src.java.main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

import src.java.main.mapper.ComputerMapper;
import src.java.main.model.*;

public final class ComputerDAO {

	private Connection connect;
	private static volatile ComputerDAO instance = null;
	private final String createStatement = "INSERT INTO computer(name, introduced, discontinued, company_id) "
			+ "VALUES(?, ?, ?, ?);";
	private final String updateStatement = "UPDATE computer set name=?, introduced=? , discontinued=?, company_id=? where id=?;";
	private final String deleteStatement = "DELETE from computer where id=?;";
	//
	private final String getStatement = "SELECT computer.id, computer.name, computer.introduced, computer.discontinued, computer.company_id"
			+ " FROM computer  LEFT JOIN company ON company_id = company.id WHERE computer.id = ?;";
	private final String getAllStatement = "SELECT * FROM computer LEFT JOIN company ON company_id = company.id ;";
	private final String getNbRowsStatement = "SELECT COUNT(*) as \"Rows\" FROM computer;";

	private ComputerDAO() {
		super();
	}

	public final static ComputerDAO getInstance() {

		if (ComputerDAO.instance == null) {

			synchronized (ComputerDAO.class) {
				if (ComputerDAO.instance == null) {
					ComputerDAO.instance = new ComputerDAO();
				}
			}
		}

		return ComputerDAO.instance;
	}

	public void create(Computer computer) throws SQLException {

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement(createStatement);

			stmt.setString(1, computer.getName());
			stmt.setTimestamp(2,
					computer.getIntroDate() != null
							? Timestamp.valueOf(computer.getIntroDate().atTime(LocalTime.MIDNIGHT))
							: null);
			stmt.setTimestamp(3,
					computer.getDiscoDate() != null
							? Timestamp.valueOf(computer.getDiscoDate().atTime(LocalTime.MIDNIGHT))
							: null);
			stmt.setInt(4, computer.getCompany().getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
	}

	public void delete(Computer computer) throws SQLException {

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt;

			stmt = connect.prepareStatement(deleteStatement);

			stmt.setInt(1, computer.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
	}

	public void update(Computer computer) throws SQLException {

		connect = ConnexionSQL.getConn();
		PreparedStatement stmt;
		try {
			stmt = connect.prepareStatement(updateStatement);

			stmt.setInt(5, computer.getId());
			
			stmt.setString(1, computer.getName());
			stmt.setTimestamp(2, Timestamp.valueOf(computer.getIntroDate().atTime(LocalTime.MIDNIGHT)));
			stmt.setTimestamp(3, Timestamp.valueOf(computer.getDiscoDate().atTime(LocalTime.MIDNIGHT)));
			stmt.setInt(4, computer.getCompany().getId());

			stmt.executeUpdate();


		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

	}

	public Computer find(int i) throws SQLException {
		Computer computer = new Computer();
		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement(getStatement);
			stmt.setInt(1, i);
			ResultSet result = stmt.executeQuery();

			if (result.first()) {
				
				computer = ComputerMapper.getInstance().getComputer(result);

			}

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

		return computer;
	}

	public ArrayList<Computer> findAll() throws SQLException {

		ArrayList<Computer> list = new ArrayList<Computer>();
		Computer computer;

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement(getAllStatement);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				computer = ComputerMapper.getInstance().getComputer(result);
				list.add(computer);
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

	public int getNbRow() throws SQLException {
		int a = 0;

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement(getNbRowsStatement);
			ResultSet result = stmt.executeQuery();

			if (result.first()) {
				a = result.getInt("Rows");

			}

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

		return a;

	}

}
