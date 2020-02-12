package src.java.main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

import src.java.main.model.*;

public final class ComputerDAO extends DAO<Computer> {

	private Connection connect;
	private static volatile ComputerDAO instance = null;

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

	@Override
	public boolean create(Computer obj) throws SQLException {

		boolean flag = false;

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt = connect.prepareStatement("insert into computer values(?,?,?,?,?)");
			stmt.setInt(1, obj.getId());
			stmt.setString(2, obj.getName());
			stmt.setObject(3, obj.getIntroDate());
			stmt.setObject(4, obj.getDiscoDate());
			stmt.setInt(5, obj.getCompanyId());

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

			flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

		return flag;

	}

	@Override
	public boolean delete(Computer obj) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {
			connect = ConnexionSQL.getConn();
			PreparedStatement stmt;
			stmt = connect.prepareStatement("delete from computer where id=?");
			stmt.setInt(1, obj.getId());
			int i = stmt.executeUpdate();

			System.out.println(i + " records deleted");

			flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

		return flag;
	}

	@Override
	public boolean update(Computer obj) throws SQLException {
		boolean flag = false;
		connect = ConnexionSQL.getConn();
		PreparedStatement stmt;
		try {
			stmt = connect.prepareStatement(
					"update computer set name=?, introduced=? , discontinued=?, company_id=? where id=?");

			stmt.setInt(5, obj.getId());
			//
			stmt.setString(1, obj.getName());
			stmt.setObject(2, obj.getIntroDate());
			stmt.setObject(3, obj.getDiscoDate());
			stmt.setInt(4, obj.getCompanyId());

			int i = stmt.executeUpdate();

			System.out.println(i + " records updated");

			flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Base non-atteinte");
		} finally {
			if (connect != null) {
				connect.close();
			}
		}

		return flag;

	}

	@Override
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
						result.getTimestamp("introduced") != null ? result.getTimestamp("introduced").toLocalDateTime()
								: null,
						result.getTimestamp("discontinued") != null
								? result.getTimestamp("discontinued").toLocalDateTime()
								: null,
						result.getInt("company_id"));

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
						result.getTimestamp("introduced") != null ? result.getTimestamp("introduced").toLocalDateTime()
								: null,
						result.getTimestamp("discontinued") != null
								? result.getTimestamp("discontinued").toLocalDateTime()
								: null,
						result.getInt("company_id"));

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


}
