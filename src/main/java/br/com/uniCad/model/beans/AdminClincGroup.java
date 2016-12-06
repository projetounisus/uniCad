package br.com.uniCad.model.beans;

import java.util.Date;
import java.util.List;

public class AdminClincGroup extends User{
	private List<AtendimentyUnityGroup> clinicGroups;

	public List<AtendimentyUnityGroup> getClinicGroups() {
		return clinicGroups;
	}

	public void setClinicGroups(List<AtendimentyUnityGroup> clinicGroups) {
		this.clinicGroups = clinicGroups;
	}

	public AdminClincGroup(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			String genre, List<AtendimentyUnityGroup> clinicGroups) {
		super(id, completeName, telephone, birthDate, address, login, genre);
		this.clinicGroups = clinicGroups;
	}

	public AdminClincGroup(String completeName, String telephone, Date birthDate, Address address, Login login,
			String genre, List<AtendimentyUnityGroup> clinicGroups) {
		super(completeName, telephone, birthDate, address, login, genre);
		this.clinicGroups = clinicGroups;
	}

	public AdminClincGroup() {
		super();
	}
}
