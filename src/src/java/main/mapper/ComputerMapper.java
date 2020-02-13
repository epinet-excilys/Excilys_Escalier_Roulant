package src.java.main.mapper;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import src.java.main.model.Computer;

public final class ComputerMapper {
	private final int nb_de_champs = 5; 
	
	
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
