package src.java.main.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import src.java.main.model.Company;
import src.java.main.model.Computer;

public final class ComputerMapper {

	
	
private static volatile ComputerMapper instance = null;
	
	
	private ComputerMapper() {
        super();
    }
	
	public final static ComputerMapper getInstance() {
		
		if (ComputerMapper.instance == null) {

	           synchronized(ComputerMapper.class) {
	             if (ComputerMapper.instance == null) {
	            	 ComputerMapper.instance = new ComputerMapper();
	             }
	           }
	        }
	        return ComputerMapper.instance;
		
	}
	
	
	

	
	public Computer getComputerFromResultSet(ResultSet resultSet) throws SQLException {
		Computer computer = new Computer();
		Company company = new Company();
			computer.setId(resultSet.getInt("id"));
			computer.setName(resultSet.getString("name"));
			//
			computer.setIntroDate(resultSet.getTimestamp("introduced") != null
					? resultSet.getTimestamp("introduced").toLocalDateTime().toLocalDate()
							: null);
			computer.setDiscoDate(resultSet.getTimestamp("discontinued") != null
					? resultSet.getTimestamp("discontinued").toLocalDateTime().toLocalDate()
							: null);
			
			//
			company.setId(resultSet.getInt("company_id"));
			company.setName(resultSet.getString("company.name"));
			computer.setCompany(company);
		
		return computer;
	}

	
	/*
	public Computer fromStringToComput(String[] result) {
		
		Computer comput = new Computer();
		int id = 0;
		String name = "";
		LocalDateTime introduced = null;
		LocalDateTime discontinued = null;
		int company_id = 0; 
		
		
			
			
			try {
				
				id = Integer.parseInt(result[0]);
				name = result[1];
				
				introduced = fromStringToLocalDateTime(result[2]);
				discontinued = fromStringToLocalDateTime(result[3]);
				company_id = Integer.parseInt(result[4]);
				
			} catch (Exception e) {
				//TODO  je sais pas quoi faire La 
			}
			
			System.out.println(new Computer(id,name,introduced, discontinued, company_id));
			return new Computer(id,name,introduced, discontinued, company_id);
			

		
	
		
	}
	*/
	
	
	
	//TODO : Ne marche pas 
	
	public LocalDateTime fromStringToLocalDateTime (String s) {

		
		if (!s.isEmpty()) {
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime dateTime = LocalDateTime.parse(s, formatter);
		
		System.out.println(dateTime+ "BLEUUUU");
		return dateTime;
		} else {
			return null;
		}
	}
	
	
	
}
