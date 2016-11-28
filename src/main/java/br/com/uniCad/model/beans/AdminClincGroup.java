package br.com.uniCad.model.beans;

import java.util.Date;
import java.util.List;

public class AdminClincGroup extends User{
	private List<ClinicGroup> clinicGroups;

	public List<ClinicGroup> getClinicGroups() {
		return clinicGroups;
	}

	public void setClinicGroups(List<ClinicGroup> clinicGroups) {
		this.clinicGroups = clinicGroups;
	}

	public AdminClincGroup(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			String genre, List<ClinicGroup> clinicGroups) {
		super(id, completeName, telephone, birthDate, address, login, genre);
		this.clinicGroups = clinicGroups;
	}

	public AdminClincGroup(String completeName, String telephone, Date birthDate, Address address, Login login,
			String genre, List<ClinicGroup> clinicGroups) {
		super(completeName, telephone, birthDate, address, login, genre);
		this.clinicGroups = clinicGroups;
	}

	public AdminClincGroup() {
		super();
	}
}
