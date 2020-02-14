package src.java.main.model;

import java.time.LocalDate;

public class Computer {
	
	private int id;
	private String name;
	private LocalDate introDate;
	private LocalDate discoDate;
	private Company company;
	
	
	
	public Computer(int id, String name, LocalDate introDate, LocalDate discoDate, Company company) {
		this.id = id;
		this.name = name;
		this.introDate = introDate;
		this.discoDate = discoDate;
		this.company = company;
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
	public LocalDate getIntroDate() {
		return introDate;
	}
	public void setIntroDate(LocalDate introDate) {
		this.introDate = introDate;
	}
	public LocalDate getDiscoDate() {
		return discoDate;
	}
	public void setDiscoDate(LocalDate discoDate) {
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
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introDate=" + introDate + ", discoDate=" + discoDate
				+ ", company=" + company + "]";
	}

	

	
	
	

}
