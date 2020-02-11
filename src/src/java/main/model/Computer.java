package src.java.main.model;

import java.sql.Date;

public class Computer {
	
	private int id;
	private String name;
	private Date introDate;
	private Date discoDate;
	private int companyId;
	
	
	
	public Computer(int id, String name, Date introDate, Date discoDate, int companyId) {
		this.id = id;
		this.name = name;
		this.introDate = introDate;
		this.discoDate = discoDate;
		this.companyId = companyId;
	}
		
	public Computer() {
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
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result + ((discoDate == null) ? 0 : discoDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((introDate == null) ? 0 : introDate.hashCode());
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
		if (companyId != other.companyId)
			return false;
		if (discoDate == null) {
			if (other.discoDate != null)
				return false;
		} else if (!discoDate.equals(other.discoDate))
			return false;
		if (id != other.id)
			return false;
		if (introDate == null) {
			if (other.introDate != null)
				return false;
		} else if (!introDate.equals(other.introDate))
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
		return "Computer [id=" + id + ", name=" + name + ", company=" + companyId + "]";
	}
	
	
	
	
	

}
