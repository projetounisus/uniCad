package br.com.uniCad.beans;

import java.util.Date;

public class Medic extends SusProfessional {
	private Speciality speciality;

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Medic(int id, String completeName, String telephone, Date birthDate, Address address, Login login,
			AtendimentUnity atendimentUnity, String crm, Speciality speciality) {
		super(id, completeName, telephone, birthDate, address, login, atendimentUnity, crm);
		this.speciality = speciality;
	}

	public Medic() {
		super();
	}	
}
