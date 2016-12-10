package br.com.uniCad.model.beans;

import java.util.Date;
import java.util.List;

public class Medic extends Professional {
	private List<Speciality> speciality;
	private String crm;

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<Speciality> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(List<Speciality> speciality) {
		this.speciality = speciality;
	}

	public Medic(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			AtendimentUnity atendimentUnity, String crm, List<Speciality> speciality, String genre) {
		super(id, completeName, telephone, birthDate, address, login, atendimentUnity, genre);
		this.crm = crm;
		this.speciality = speciality;
	}

	public Medic() {
		super();
	}	
}
