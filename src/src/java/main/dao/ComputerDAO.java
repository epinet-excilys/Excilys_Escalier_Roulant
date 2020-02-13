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

import src.java.main.model.*;

public final class ComputerDAO {

	private Connection connect;
	private static volatile ComputerDAO instance = null;
	private final String createStatement = "INSERT INTO computer(name, introduced, discontinued, company_id) "
			+ "VALUES(?, ?, ?, ?);";
	private final String updateStatement = "UPDATE computer set name=?, introduced=? , discontinued=?, company_id=? where id=?";
	private final String deleteStatement = "DELETE from computer where id=?";

	private ComputerDAO() {
		super();
		// TODO Auto-generated constructor stub
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			//
			stmt.setString(1, computer.getName());
			stmt.setTimestamp(2, Timestamp.valueOf(computer.getIntroDate().atTime(LocalTime.MIDNIGHT)));
			stmt.setTimestamp(3, Timestamp.valueOf(computer.getDiscoDate().atTime(LocalTime.MIDNIGHT)));
			stmt.setInt(4, computer.getCompany().getId());

			int i = stmt.executeUpdate();

			System.out.println(i + " records updated");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Base non-atteinte");
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

	}

	public Computer find(int i) throws SQLException {
		Computer computer = new Computer();
		// TODO Auto-generated method stub
		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement("SELECT * FROM computer WHERE id = ? ");
			stmt.setInt(1, i);
			ResultSet result = stmt.executeQuery();

			if (result.first()) {
				computer = new Computer(result.getInt("id"), result.getString("name"),
						result.getTimestamp("introduced") != null
								? result.getTimestamp("introduced").toLocalDateTime().toLocalDate()
								: null,
						result.getTimestamp("discontinued") != null
								? result.getTimestamp("discontinued").toLocalDateTime().toLocalDate()
								: null,
						new Company(result.getInt("company_id")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Base non-atteinte");
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
			PreparedStatement stmt = connect.prepareStatement("select * from computer");
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				computer = new Computer(result.getInt("id"), result.getString("name"),
						result.getTimestamp("introduced") != null
								? result.getTimestamp("introduced").toLocalDateTime().toLocalDate()
								: null,
						result.getTimestamp("discontinued") != null
								? result.getTimestamp("discontinued").toLocalDateTime().toLocalDate()
								: null,
						new Company(result.getInt("company_id")));
				list.add(computer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Base non-atteinte");
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
			PreparedStatement stmt = connect.prepareStatement("SELECT COUNT(*) as \"Rows\" FROM computer;");
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
