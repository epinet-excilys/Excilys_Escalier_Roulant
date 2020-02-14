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

	private static volatile ComputerDAO instance = null;
	private final String createStatement = "INSERT INTO computer(name, introduced, discontinued, company_id) "
			+ "VALUES(?, ?, ?, ?);";
	private final String updateStatement = "UPDATE computer set name=?, introduced=? , discontinued=?, company_id=? where id=?;";
	private final String deleteStatement = "DELETE from computer where id=?;";
	//
	private final String getStatement = "SELECT computer.id, computer.name, computer.introduced, computer.discontinued, computer.company_id"
			+ " FROM computer  LEFT JOIN company ON company_id = company.id WHERE computer.id = ?;";
	private final String getAllStatement = "SELECT * FROM computer LEFT JOIN company ON company_id = company.id ;";
	private final String getAllPaginateStatement = "SELECT * FROM computer LEFT JOIN company ON company_id = company.id LIMIT ?, ?;";
	private final String getNbRowsStatement = "SELECT COUNT(*) as \"Rows\" FROM computer;";

	private ResultSet result;

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

		try (Connection connect = ConnexionSQL.getConn();
				PreparedStatement stmt = connect.prepareStatement(createStatement);) {
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
		}
	}

	public void delete(Computer computer) throws SQLException {

		try (Connection connect = ConnexionSQL.getConn();
				PreparedStatement stmt = connect.prepareStatement(deleteStatement);) {

			stmt.setInt(1, computer.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		}
	}

	public void update(Computer computer) throws SQLException {

		try (Connection connect = ConnexionSQL.getConn();
				PreparedStatement stmt = connect.prepareStatement(updateStatement);) {

			stmt.setInt(5, computer.getId());

			stmt.setString(1, computer.getName());
			stmt.setTimestamp(2, Timestamp.valueOf(computer.getIntroDate().atTime(LocalTime.MIDNIGHT)));
			stmt.setTimestamp(3, Timestamp.valueOf(computer.getDiscoDate().atTime(LocalTime.MIDNIGHT)));
			stmt.setInt(4, computer.getCompany().getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		}

	}

	public Computer find(int i) throws SQLException {

		Computer computer = new Computer();
		try (Connection connect = ConnexionSQL.getConn();
				PreparedStatement stmt = connect.prepareStatement(getStatement);) {
			stmt.setInt(1, i);
			result = stmt.executeQuery();

			if (result.first()) {

				computer = ComputerMapper.getInstance().getComputerFromResultSet(result);

			}

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			result.close();
		}

		return computer;
	}

	public ArrayList<Computer> findAll() throws SQLException {

		ArrayList<Computer> list = new ArrayList<Computer>();
		Computer computer;

		try (Connection connect = ConnexionSQL.getConn();
				PreparedStatement stmt = connect.prepareStatement(getAllStatement);) {

			result = stmt.executeQuery();
			while (result.next()) {
				computer = ComputerMapper.getInstance().getComputerFromResultSet(result);
				list.add(computer);
			}

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			result.close();

		}

		return list;
	}

	public ArrayList<Computer> findAllPaginate(int ligneDebutOffSet, int taillePage) throws SQLException {

		ArrayList<Computer> list = new ArrayList<Computer>();
		Computer computer;

		try (Connection connect = ConnexionSQL.getConn();
				PreparedStatement stmt = connect.prepareStatement(getAllPaginateStatement);) {
			stmt.setInt(1, ligneDebutOffSet);
			stmt.setInt(2, taillePage);
			result = stmt.executeQuery();
			while (result.next()) {
				computer = ComputerMapper.getInstance().getComputerFromResultSet(result);
				list.add(computer);
			}

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			result.close();

		}

		return list;
	}

	public int getNbRow() throws SQLException {
		int a = 0;

		try (Connection connect = ConnexionSQL.getConn();
				PreparedStatement stmt = connect.prepareStatement(getNbRowsStatement);) {
			result = stmt.executeQuery();

			if (result.first()) {
				a = result.getInt("Rows");

			}

		} catch (SQLException e) {
			// TODO REMPLIR AVEC LOG
		} finally {
			result.close();
		}

		return a;

	}

}
