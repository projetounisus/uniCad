package br.com.uniCad.model.beans;

public class Speciality extends AbstractBean{
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Speciality(int id, String name, String description) {
		super(id);
		this.name = name;
		this.description = description;
	}
	public Speciality(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Speciality() {
		super();
	}
}
