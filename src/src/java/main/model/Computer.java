package src.java.main.model;

import java.sql.Date;

public class Computer {
	
	private int id;
	private String name;
	private Date introDate;
	private Date discoDate;
	private Company company;
	
	
	
	public Computer(int id, String name, Date introDate, Date discoDate, Company company) {
		this.id = id;
		this.name = name;
		this.introDate = introDate;
		this.discoDate = discoDate;
		this.company = company;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getIntroDate() {
		return introDate;
	}
	public void setIntroDate(Date introDate) {
		this.introDate = introDate;
	}
	public Date getDiscoDate() {
		return discoDate;
	}
	public void setDiscoDate(Date discoDate) {
		this.discoDate = discoDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	
	
	
	
	

}
