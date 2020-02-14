package src.java.main.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.java.main.model.Company;

public final class CompanyMapper {

	private static volatile CompanyMapper instance = null;

	private CompanyMapper() {
		super();
	}

	public final static CompanyMapper getInstance() {

		if (CompanyMapper.instance == null) {

			synchronized (CompanyMapper.class) {
				if (CompanyMapper.instance == null) {
					CompanyMapper.instance = new CompanyMapper();
				}
			}
		}
		return CompanyMapper.instance;

	}
	
	public Company getCompanyFromResultSet(ResultSet resultSet) throws SQLException {
		
		return new Company(resultSet.getInt("id"), resultSet.getString("name"));
		
		
	}
	

}
