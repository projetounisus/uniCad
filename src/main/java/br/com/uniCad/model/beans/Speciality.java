package br.com.uniCad.model.beans;

import java.util.List;

public class Speciality extends AbstractBean{
	private String name;
	private String description;
	private List<RegisterType> registersTypes;
	
	public List<RegisterType> getRegistersTypes() {
		return registersTypes;
	}
	public void setRegistersTypes(List<RegisterType> registersTypes) {
		this.registersTypes = registersTypes;
	}
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
	public Speciality(int id, String name, String description, List<RegisterType> registerTypes) {
		super(id);
		this.name = name;
		this.description = description;
		this.registersTypes = registerTypes;
	}
	public Speciality(String name, String description, List<RegisterType> registerTypes) {
		super();
		this.name = name;
		this.description = description;
		this.registersTypes = registerTypes;
	}
	public Speciality() {
		super();
	}
}
