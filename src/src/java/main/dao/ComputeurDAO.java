package src.java.main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import src.java.main.model.*;

public final class ComputeurDAO extends DAO<Computer> {

	private Connection connect;
	private static volatile ComputeurDAO instance = null;

	private ComputeurDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final static ComputeurDAO getInstance() {
		
		if (ComputeurDAO.instance == null) {

			synchronized (ComputeurDAO.class) {
				if (ComputeurDAO.instance == null) {
					ComputeurDAO.instance = new ComputeurDAO();
				}
			}
		}

		return ComputeurDAO.instance;
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
	public Computer find(int i) throws SQLException {
		Computer computer = new Computer();
		// TODO Auto-generated method stub

		try {
			connect = ConnexionSQL.getInstance();
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM computer WHERE id = " + i);
			if (result.first())
				computer = new Computer(i, result.getString("name"), result.getDate("introduced"),
						result.getDate("discontinued"), result.getInt("company_id"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.close();
		}

		return computer;
	}

	public ArrayList<Computer> findAll() throws SQLException {

		ArrayList<Computer> list = new ArrayList<Computer>();
		Computer computer;

		try {
			connect = ConnexionSQL.getInstance();
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM computer");

			while (result.next()) {
				computer = new Computer(result.getInt("id"), result.getString("name"), result.getDate("introduced"),
						result.getDate("discontinued"), result.getInt("company_id"));

				list.add(computer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.close();
		}

		return list;
	}

	// Pas utile pour le moment
	private Date FromStringtoDate(String s) throws ParseException {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

		Date date2 = (Date) formatter2.parse(s);

		return date2;

	}

}
