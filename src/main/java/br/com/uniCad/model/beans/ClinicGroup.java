package br.com.uniCad.model.beans;

public class ClinicGroup extends AbstractBean{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClinicGroup(String name) {
		super();
		this.name = name;
	}

	public ClinicGroup(int id, String name) {
		super(id);
		this.name = name;
	}

	public ClinicGroup() {
		super();
	}
}
